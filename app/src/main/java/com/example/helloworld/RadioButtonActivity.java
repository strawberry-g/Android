package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    //RadioGroup组,多个单选框之间切换选择,继承自LinearLayout
    private RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup1 = findViewById(R.id.rg_1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //radioGroup是接受监测的按钮组，i是每个按钮自带的ID，按在xml中命名的顺序排布
                RadioButton radioButton = radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();

                //获取因点击而变化的id
                //int radioId = radioGroup.getCheckedRadioButtonId();
                //把id指示的按钮返回给当前显示的按钮，看起来就像是因为点击而切换按钮
                //RadioButton radioButton = MainActivity.this.findViewById(radioId);
                //把当前显示的按钮的值放到显示文本TextView中
                //question.setText(radioButton.getText());
            }
        });
    }
}
