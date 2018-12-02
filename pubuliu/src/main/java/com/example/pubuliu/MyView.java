package com.example.pubuliu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyView extends LinearLayout {
    //定义每行最大的字符串
    final int mMaxSize=22;
    //传入字符的list集合
    List<String> list = new ArrayList<>();
    Context mContext;

    public void setList(List<String> list) {
        //直接用新的类表重新绘制
        this.list = list;
        showData();
    }

    //构造方法
    public MyView(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }
    //初始化方法
    private void init() {
        //设置最外层的布局
        setOrientation(VERTICAL);
    }

    //绘制布局
    private void showData() {
        //每一次都要更新新的布局，所以要把前一次的清除
        removeAllViews();
        //现加载一条横向布局
        LinearLayout linearLayout_h = (LinearLayout) View.inflate(mContext,R.layout.item_water_fall_h,null);
        //添加到纵向布局shang
        addView(linearLayout_h);
        int len=0;
        for (String str :list){
            len+=str.length();
            if (len>mMaxSize){
                //向纵向布局中加一个横向布局
                linearLayout_h = (LinearLayout) View.inflate(mContext,R.layout.item_water_fall_h,null);
                addView(linearLayout_h);
                len=str.length();
            }
            //添加text并赋值
            View view = View.inflate(mContext,R.layout.item_water_fall_text,null);
            TextView textView = view.findViewById(R.id.water_fall);
            textView.setText(str);
            linearLayout_h.addView(view);
            //设置权重，
            LinearLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.weight=1;
            view.setLayoutParams(layoutParams);
        }
    }
}
