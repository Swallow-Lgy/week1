package com.example.week_3;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WeekLayoutView extends LinearLayout {
    private int mChildMaxHeigth ;
    private int mHSpace=20;
    private int mVSpace=20;
    public WeekLayoutView(Context context) {
        super(context);
    }

    public WeekLayoutView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }
   //定义单个孩子的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeigth = MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的大小
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findChindMaxHeigth();
        int left=0,top=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view =  getChildAt(i);
            if (left!=0){
                if (left+view.getMeasuredWidth()>sizeWidth){
                    top+=mChildMaxHeigth+mVSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;
        }
        setMeasuredDimension(sizeWidth,(top+mChildMaxHeigth)>sizeHeigth?sizeHeigth:top+mChildMaxHeigth);
    }
   //孩子在整体布局中的大小

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findChindMaxHeigth();
        int left=0,top=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view =  getChildAt(i);
            if (left!=0){
                if (left+view.getMeasuredWidth()>getWidth()){
                    top+=mChildMaxHeigth+mVSpace;
                    left=0;
                }
            }
            //???????????????
            view.layout(left,top,view.getMeasuredWidth()+left,mChildMaxHeigth+top);
            left+=view.getMeasuredWidth()+mHSpace;

        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void findChindMaxHeigth(){
        mChildMaxHeigth=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view =  getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeigth){
                mChildMaxHeigth=view.getMeasuredHeight();
            }
        }
    }
}
