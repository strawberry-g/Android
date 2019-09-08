package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private TextView testContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        testContent = findViewById(R.id.btn_test1);

        Intent intent = getIntent();
        //Bundle data = intent.getExtras();
        //第二种：Bundle data = intent.getBundleExtra("data");

        //若name1不存在,默认赋值AA,存在则显示原值
        //testContent.setText(String.format("name=%s,age=%d",
        //        data.getString("name"),data.getInt("age"),
        //        data.getString("name1","AA")));

        //Serializable时
        // User user = (User) intent.getSerializableExtra("user");

        //Parcelable时
        User user = intent.getParcelableExtra("user");
        testContent.setText(String.format("User info(name=%s,age=%d)",user.getName(),user.getAge()));
    }
}
