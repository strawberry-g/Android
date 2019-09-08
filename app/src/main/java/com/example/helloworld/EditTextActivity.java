package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    //activity_edit_text上的控件声明
    private Button editBtn;
    private EditText myEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editBtn = findViewById(R.id.edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
            }
        });

        myEdit = findViewById(R.id.ed_1);
        //用来监听用户的输入状态 可以在监听中改变用户输入的内容或者提示用户输入内容不合法等
        myEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //charSequence  输入框中改变前的字符串信息
                //i 输入框中改变前的字符串的起始位置
                //i1 输入框中改变前后的字符串改变数量一般为0
                //i2 输入框中改变后的字符串与起始位置的偏移量
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //charSequence 输入框中改变后的字符串
                //i：输入框中改变后的字符串开始的位置
                //i1：输入框中改变前的字符串的位置 默认为0
                // i2：输入框中改变后一共输入的字符串个数
                //记录editText中的字符输入
                Log.d("editText",charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //edit  输入结束呈现在输入框中的信息
            }
        });
    }
}
