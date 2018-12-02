package com.example.week_3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TitleBar extends LinearLayout {
    private Context mContext;
    public TitleBar(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public TitleBar(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }
    public void init(){
        View view = View.inflate(mContext,R.layout.tiltebar,null);
        final EditText editText = view.findViewById(R.id.search_edit);
        view.findViewById(R.id.sreach_image).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnButtonClickLinster!=null){
                    mOnButtonClickLinster.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }
    //定义成员变量
    OnButtonClickLinster mOnButtonClickLinster;
    public void setOnButtonClickLister(OnButtonClickLinster onButtonClickLister){
           mOnButtonClickLinster=onButtonClickLister;
    }
    //定义接口
    public  interface OnButtonClickLinster{
        void onButtonClick(String str);
    }
}
