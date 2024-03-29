package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.helloworld.gridview.GridViewActivity;
import com.example.helloworld.listview.ListViewActivity;
import com.example.helloworld.recyclerview.RecyclerViewActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

//应用程序文件，将被转化为Dalvik可执行文件并运行
public class MainActivity extends AppCompatActivity {
    //每个控件声明空间
    private Button myBd;//跳转到指定网页
    private Button myButtonTextView;//文字页面
    private Button myButton;//按钮
    private Button myEditText;//输入框、文本框
    private Button myRadioButton;//单选框
    private Button myCheckBox;//复选框
    private Button myImgView;//图片
    private Button myListView;//列表视图
    private Button myGridV;//网格视图
    private Button myTest;//传递参数
    private Button myRv;//通用视图

    //onCreate方法activity创建时调用，是一个activity声明周期的开始
    //Bundle类型的数据与Map类型的数据相似，都是以key-value的形式存储数据的。
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //指定当前Activity的布局文件为res/layout/activity_main.xml
        //gen/com.example.helloworld/R.java文件是活动的Java文件（如MainActivity.java）和资源（如strings.xml）之间的胶水。
        //这是一个自动生成的文件，不要修改R.java文件的内容
        //活动类从项目的res/layout中的XML文件加载所有的UI组件
        setContentView(R.layout.activity_main);

        //findViewById根据控件自定义的id找到空间
        myButtonTextView = findViewById(R.id.btn_textview);
        myButton = findViewById(R.id.btn_button);
        myEditText = findViewById(R.id.btn_edittext);
        myRadioButton = findViewById(R.id.btn_radio);
        myCheckBox = findViewById(R.id.btn_checkBox);
        myBd = findViewById(R.id.btn_bdyx);
        myImgView = findViewById(R.id.btn_img_view);
        myListView = findViewById(R.id.btn_list_view);
        myGridV = findViewById(R.id.btn_grid_view);
        myTest = findViewById(R.id.btn_test);
        myRv = findViewById(R.id.btn_rv);

        setOnClickListeners();//调用下面的点击事件方法
    }

    //点击事件
    private void setOnClickListeners(){
        OnClick onClick = new OnClick();
        //每个控件设置监听点击事件
        myButtonTextView.setOnClickListener(onClick);
        myButton.setOnClickListener(onClick);
        myEditText.setOnClickListener(onClick);
        myRadioButton.setOnClickListener(onClick);
        myCheckBox.setOnClickListener(onClick);
        myImgView.setOnClickListener(onClick);
        myBd.setOnClickListener(onClick);
        myListView.setOnClickListener(onClick);
        myGridV.setOnClickListener(onClick);
        myTest.setOnClickListener(onClick);
        myRv.setOnClickListener(onClick);
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
                case R.id.btn_bdyx:
                    //跳转到百度首页
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                    break;
                case R.id.btn_img_view:
                    //跳转到ImageView演示页面
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_list_view:
                    //跳转到ListView演示页面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_grid_view:
                    //跳转到GridView演示页面
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_test:
                    //跳转到测试页面
                    intent = new Intent(MainActivity.this, TestActivity.class);
                    //传递数据包Bundle
                    /*Bundle b = new Bundle();
                    b.putString("name","Android");
                    b.putInt("age",18);
                    intent.putExtras(b);*/
                    //第二种intent.putExtras("data",b)

                    intent.putExtra("user",new User("Android",20));
                    break;
                case R.id.btn_rv:
                    //跳转到RecyclerView页面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
