package com.example.week_2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WeekFlowLayout extends LinearLayout {
    //孩子最高的一个
    private int mChildMaxHeight;
    //每个孩子的左右的间距
    private int mHSpace;
    //每个孩子的上下间距
    private int mVSpace;
    public WeekFlowLayout(Context context) {
        super(context);
    }

    public WeekFlowLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sixeHeigth = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findMaxChildHeigth();
        int left=0,top=0;
        int countChild=getChildCount();
        for (int i=0;i<countChild;i++){
            View view = getChildAt(i);
            if (left!=0){
                if (left+view.getMeasuredWidth()>sizeWidth){
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;
        }
        setMeasuredDimension(sizeWidth,(top+mChildMaxHeight)>sixeHeigth?sixeHeigth:top+mChildMaxHeight);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildHeigth();
        //初始化
        int left=0,top=0;
        //得到所有的孩子
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View view  = getChildAt(i);
            if (left!=0){
                if (left+view.getMeasuredWidth()>getWidth()){
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            //安排孩子的位置
            view.layout(left,top,left+view.getMeasuredWidth(),top+mChildMaxHeight);
             left+=view.getMeasuredWidth()+mHSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void findMaxChildHeigth(){
        mChildMaxHeight=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeight){
              mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    };

}
