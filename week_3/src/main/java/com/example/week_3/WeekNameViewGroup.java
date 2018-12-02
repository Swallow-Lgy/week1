package com.example.week_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class WeekNameViewGroup extends TextView {

    public WeekNameViewGroup(Context context) {
        super(context);
    }

    public WeekNameViewGroup(Context context,  AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WeekNameViewGroup);
        int color = typedArray.getColor(R.styleable.WeekNameViewGroup_textColor, Color.BLACK);
        setTextColor(color);
    }
}
