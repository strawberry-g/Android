package com.example.helloworld.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.helloworld.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button linearRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        linearRv = findViewById(R.id.rv_linear);

        linearRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到LinearRecyclerView页面
                Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
