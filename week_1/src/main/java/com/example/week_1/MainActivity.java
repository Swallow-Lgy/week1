package com.example.week_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private UserDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new UserDao(this);
        initData();
    }

    private void initData() {
        final EditText text = findViewById(R.id.edit);
        final MyViewGroup group = findViewById(R.id.view);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText(text.getText().toString());
                 tv.setTextColor(Color.RED);
                 tv.setTextSize(20);

                tv.setBackgroundResource(R.drawable.edit_bg);
                group.addView(tv);
                dao.add(text.getText().toString());
            }
        });
    }
}
