package com.example.pubuliu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> strlist = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
       final EditText editText = findViewById(R.id.etid);
       final MyView view = findViewById(R.id.water);
       findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String str = editText.getText().toString();
               strlist.add(str);
               view.setList(strlist);
           }
       });
    }
}
