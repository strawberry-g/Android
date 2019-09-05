package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox cb5;
    private CheckBox cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb5 = findViewById(R.id.cb_5);
        cb6 = findViewById(R.id.cb_6);

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                boolean isChecked = false;
                Toast.makeText(CheckBoxActivity.this,isChecked?"选中":"未选中",Toast.LENGTH_SHORT).show();
            }
        });
        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                boolean isChecked = false;
                Toast.makeText(CheckBoxActivity.this,isChecked?"选中":"未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
