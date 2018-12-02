package com.example.week_3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class LoginActivity extends AppCompatActivity {
    private SearchDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final WeekLayoutView layoutView = findViewById(R.id.layoutView);
        final WeekLayoutView layoutView1 = findViewById(R.id.layoutView1);
       dao = new SearchDao(LoginActivity.this);
       TitleBar bar =   findViewById(R.id.title);
        final List<SearchBean> select = dao.select();
        for (int i=0;i<select.size();i++){
            TextView tv = new TextView(LoginActivity.this);
            tv.setTextColor(Color.RED);
            tv.setText(select.get(i).getName());
            tv.setBackgroundResource(R.drawable.edit_bg);
            layoutView.addView(tv);
            final int index=i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.del(select.get(index).getUuid());
                    layoutView.removeView(v);
                }
            });
        }
       bar.setOnButtonClickLister(new TitleBar.OnButtonClickLinster() {
           @Override
           public void onButtonClick(String str) {
               UUID uuid = UUID.randomUUID();
               TextView tv = new TextView(LoginActivity.this);
               tv.setTag(uuid);
               tv.setTextColor(Color.RED);
               tv.setText(str);
               tv.setBackgroundResource(R.drawable.edit_bg);
               layoutView.addView(tv);
               dao.add(str,uuid.toString());
               tv.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dao.del(v.getTag().toString());
                       layoutView.removeView(v);
                   }
               });
           }
       });
       for (int i=0;i<30;i++){
           TextView tv = new TextView(LoginActivity.this);
           tv.setTextColor(Color.RED);
           tv.setText("热门"+i);
           tv.setBackgroundResource(R.drawable.edit_bg);
           layoutView1.addView(tv);
       }
    }
}
