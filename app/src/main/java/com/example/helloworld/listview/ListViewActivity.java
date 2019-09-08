package com.example.helloworld.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.helloworld.R;

public class ListViewActivity extends AppCompatActivity {
    //声明列表视图
    private ListView myLV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myLV1 = findViewById(R.id.lv_1);

        //声明适配器，视图调用适配器
        MyListAdapter myListAdapter = new MyListAdapter(ListViewActivity.this);
        myLV1.setAdapter(myListAdapter);

        //监听item点击事件
        myLV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i：记录当前点击的是第几个item
                Toast.makeText(ListViewActivity.this,"点击 i:"+i,Toast.LENGTH_SHORT).show();
            }
        });

        //监听item长按点击事件
        myLV1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i：记录当前点击的是第几个item
                Toast.makeText(ListViewActivity.this,"长按 i:"+i,Toast.LENGTH_SHORT).show();
                //false会弹出两个事件提醒
                return true;
            }
        });
    }
}
