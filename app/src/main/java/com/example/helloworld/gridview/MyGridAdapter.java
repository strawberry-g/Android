package com.example.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class MyGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyGridAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null){
            //获取view的布局
            view = layoutInflater.inflate(R.layout.layout_gridview_item,null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.gv_img);
            viewHolder.textView = view.findViewById(R.id.gv_tv);
            //View中的setTag(Object)表示给View添加一个格外的数据，以后可以用getTag()将这个数据取出来
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        viewHolder.textView.setText("网格视图");
        //在线导图
        Glide.with(context)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567746977975&di=ba396fb0f357c745161f97e37ea10d92&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F04%2F20180704215302_vjlpa.jpg")
                .into(viewHolder.imageView);

        return view;
    }
}
