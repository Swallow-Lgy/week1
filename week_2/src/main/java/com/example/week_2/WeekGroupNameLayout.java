package com.example.week_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class WeekGroupNameLayout extends TextView {

    public WeekGroupNameLayout(Context context) {
        super(context);
    }

    public WeekGroupNameLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
        //自定义属性
        //1:在values文件夹下建立attr.xml文件
        //2:写<decler....标签
        //3:写attr 标签name:方法名format属性
        //在布局文件根控件中写xmlns:app="http://schemas.android.com/apk/res-auto"
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WeekGroupNameLayout);
        int color = typedArray.getColor(R.styleable.WeekGroupNameLayout_textColor, Color.BLACK);
        setTextColor(color);
        //最后回收
        typedArray.recycle();
    }
}
