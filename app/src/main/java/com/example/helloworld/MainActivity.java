package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //声明空间
    private Button myButtonTextView;
    private Button myButton;
    private Button myEditText;
    private Button myRadioButton;
    private Button myCheckBox;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //指定当前Activity的布局文件为res/layout/main.xml
        setContentView(R.layout.activity_main);

        //找到空间
        myButtonTextView = findViewById(R.id.btn_textview);
        myButton = findViewById(R.id.btn_button);
        myEditText = findViewById(R.id.btn_edittext);
        myRadioButton = findViewById(R.id.btn_radio);
        myCheckBox = findViewById(R.id.btn_checkBox);
        setOnClickListeners();
    }

    private void setOnClickListeners(){
        OnClick onClick = new OnClick();
        myButtonTextView.setOnClickListener(onClick);
        myButton.setOnClickListener(onClick);
        myEditText.setOnClickListener(onClick);
        myRadioButton.setOnClickListener(onClick);
        myCheckBox.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_textview:
                    //跳转到TextView演示页面
                    intent = new Intent(MainActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //跳转到Button演示页面
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditText演示页面
                    intent = new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radio:
                    //跳转到RadioButton演示页面
                    intent = new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkBox:
                    //跳转到CheckBox演示页面
                    intent = new Intent(MainActivity.this,CheckBoxActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
