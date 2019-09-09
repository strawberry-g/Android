package com.example.helloworld.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.helloworld.R;
import com.example.helloworld.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

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

        //this.getServletData("http://localhost:8080/appser/servlet/AjaxServlet");
    }

    //用于获取服务器的数据
    public void getServletData(String url){
        //配置当前请求的地址
        RequestParams params = new RequestParams(url);
        //如果有参数则配置传输到服务器参数
        //params.setSslSocketFactory(...); // 设置ssl
        //params.addQueryStringParameter("wd", "xUtils");
        //发送GET请求,并且配置了回调函数 必须开启了网络权限
        x.http().get(params, new Callback.CommonCallback<String>() {
            //请求成功
            @Override
            public void onSuccess(String result) {
                //Toast.makeText(x.app(), result, Toast.LENGTH_LONG).show();
                //先把字符串转回为json格式
                Gson gson = new Gson();
                List<User> userList = gson.fromJson(result,new TypeToken<List<User>>(){}.getType());
                myLV1 = findViewById(R.id.btn_list_view);
                myLV1.setAdapter(new ListViewAdapter(userList));
            }

            //请求失败
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            //请求取消
            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
            }

            //请求完成(成功或失败,用于释放资源)
            @Override
            public void onFinished() {

            }
        });
    }
}
