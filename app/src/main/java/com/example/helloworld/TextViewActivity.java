package com.example.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    //声明空间
    //private TextView myTextView4,myTextView5;
    private TextView myTextView4;
    private TextView myTextView5;
    private TextView myTextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        //找到空间
        myTextView4 = findViewById(R.id.tv_4);
        //中划线
        myTextView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        //去除锯齿
        myTextView4.getPaint().setAntiAlias(true);

        myTextView5 = findViewById(R.id.tv_5);
        //下划线
        myTextView5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        myTextView6 = findViewById(R.id.tv_6);
        //下划线
        myTextView6.setText(Html.fromHtml("<u>潇潇暮雨子规啼</u>"));
    }
}
