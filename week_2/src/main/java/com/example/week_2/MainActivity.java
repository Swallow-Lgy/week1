package com.example.week_2;

import android.graphics.Color;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
     private SearchDao searchDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchDao = new SearchDao(this);
        init();
    }

    private void init() {
        final WeekFlowLayout flowLayout = findViewById(R.id.search);
       WeekFlowLayout hot =  findViewById(R.id.hot_search);
        TitleBarView barView = findViewById(R.id.title);
        barView.setmOnButtonClickListenter(new TitleBarView.OnButtonClickListener() {
            @Override
            public void onButtonClick(String str) {
                UUID uuid = UUID.randomUUID();
                TextView tv = new TextView(MainActivity.this);
                tv.setText(str);
                tv.setTag(uuid);
                tv.setTextSize(20);
                tv.setTextColor(Color.RED);
                tv.setBackgroundResource(R.drawable.edit_bg);
                searchDao.add(str,uuid.toString());
                flowLayout.addView(tv);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uuid = String.valueOf(v.getTag());
                        searchDao.del(uuid);
                        flowLayout.removeView(v);
                    }
                });
            }
        });
        for (int i=0;i<30;i++){
            TextView tv = new TextView(MainActivity.this);
            tv.setText("热门"+i);
            tv.setTextSize(20);
            tv.setTextColor(Color.BLUE);
            tv.setBackgroundResource(R.drawable.edit_bg);
            tv.setPadding(3,3,3,3);
            hot.addView(tv);
        }
    }
}
