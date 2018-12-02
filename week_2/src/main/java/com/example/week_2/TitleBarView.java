package com.example.week_2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TitleBarView extends LinearLayout {
    Context mContext;
    public TitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleBarView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        //添加布局
        View view = View.inflate(mContext,R.layout.title_bar,null);
       final EditText editText =  view.findViewById(R.id.edit);
      view.findViewById(R.id.search_title).setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
             if (mOnButtonClickListenter!=null){
                 mOnButtonClickListenter.onButtonClick(editText.getText().toString());
             }
          }
      });
      //不要忘记视图添加
      addView(view);
    }
    //设置成员变量
    OnButtonClickListener mOnButtonClickListenter;
    //传入，并且给成员赋值
    //第五步 在应的地方回调方法
    public void setmOnButtonClickListenter(OnButtonClickListener onButtonClickListenter){
        mOnButtonClickListenter=onButtonClickListenter;
    }

    //定义接口
    public interface OnButtonClickListener{
        void onButtonClick(String str);
    }
}
