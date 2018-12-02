package com.example.week;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WeekFlowLayout extends LinearLayout {
    //孩子中最高的一个
    private int mChildMaxHeight;
    //每个孩子的左右的边距
    private int mHSpace=20;
    //每行的上下的间距
    private int  mVSpace=20;

    public WeekFlowLayout(Context context) {
        super(context);
    }
    public WeekFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //拿到父元素推荐的宽高以及计算模式
        int sizeWidth=MeasureSpec.getSize(widthMeasureSpec);
        int sixeHeigth=MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的大小
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //寻找孩子中最高的一个,找到的值会放到mChildMaxHeight
         findMaxChildMaxHeight();
         //初始化
        int left=0,top=0;
        //循环所有的孩子
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            //是否是一行的开头
            if (left!=0){
                //需要换行，放不下了
                if (left+view.getMeasuredWidth()>getWidth()){
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
        findMaxChildMaxHeight();
        int left=0,top=0;
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            //是否是一行的开头
            if (left!=0){
                //需要换行了，因为放不下了
                if (left+view.getMeasuredWidth()>getWidth()){
                    //计算细下一行的top
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
    //寻找孩子中最高的一个
    private void findMaxChildMaxHeight(){
        mChildMaxHeight=0;
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeight){
                mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    }

}
