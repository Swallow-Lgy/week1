package com.example.week;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TitleViewGroup extends LinearLayout {
    Context mContext;
    public TitleViewGroup(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public TitleViewGroup(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext,R.layout.item_tiltle,null);
    }

}
