package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    //声明空间
    private Button btn_3;
    private TextView btn_tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        //找到空间
        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在界面上弹出提示信息
                Toast.makeText(ButtonActivity.this,"按钮3点击成功！",Toast.LENGTH_SHORT).show();
            }
        });

        btn_tv1 = findViewById(R.id.btn_tv1);
        btn_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在界面上弹出提示信息
                Toast.makeText(ButtonActivity.this,"文字点击成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //按钮3的onclick方法
    public void showToast(View view){
        //在界面上弹出提示信息
        Toast.makeText(this,"按钮4点击成功！",Toast.LENGTH_SHORT).show();
    }
}
