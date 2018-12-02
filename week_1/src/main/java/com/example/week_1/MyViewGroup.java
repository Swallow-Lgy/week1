package com.example.week_1;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MyViewGroup extends LinearLayout {
    //最高的一个
    private int mChildMaxHeight;
    private int mHSpace=20;
    private int mVSpace=20;

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context,AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
         int sixeWidth=MeasureSpec.getSize(widthMeasureSpec);
         int sixeHeigth=MeasureSpec.getSize(heightMeasureSpec);
         measureChildren(widthMeasureSpec,heightMeasureSpec);
         //最大的孩子
        finMaxChildMaxHeight();
        //初始化值
        int left=0,top=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if (left!=0){
                if (view.getMeasuredWidth()+left>sixeWidth){
                   top+=mChildMaxHeight+mVSpace;
                   left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;
        }
        setMeasuredDimension(sixeWidth,(top+mChildMaxHeight)>sixeHeigth?sixeHeigth:top+mChildMaxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        finMaxChildMaxHeight();
         int left=0,top=0;
         int childCount=getChildCount();
         for (int i=0;i<childCount;i++){
             View view = getChildAt(i);
             if (left!=0){
                 if (left+view.getMeasuredWidth()>getWidth()){
                     top+=mChildMaxHeight+mVSpace;
                     left=0;
                 }
             }
             view.layout(left,top,left+view.getMeasuredWidth(),top+mChildMaxHeight);
             left+=view.getMeasuredWidth()+mHSpace;
         }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    //找到最大的孩子
    private void finMaxChildMaxHeight(){
        mChildMaxHeight=0;
        int childCount=getChildCount();
        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeight){
                mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    }
}
