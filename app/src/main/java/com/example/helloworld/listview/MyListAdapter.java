package com.example.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.helloworld.R;

//视图适配器
public class MyListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tv1,tv2,tv3;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            //视图绑定
            view = layoutInflater.inflate(R.layout.layout_listitem,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.lv_iv);
            viewHolder.tv1 = view.findViewById(R.id.lv_tv1);
            viewHolder.tv2 = view.findViewById(R.id.lv_tv2);
            viewHolder.tv3 = view.findViewById(R.id.lv_tv3);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
            //给控件tv1,tv2,tv3,imageView赋值
            viewHolder.tv1.setText("标题");
            viewHolder.tv2.setText("2019-9-6");
            viewHolder.tv3.setText("星期五");
            Glide.with(context)
                    .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567746977975&di=ba396fb0f357c745161f97e37ea10d92&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F04%2F20180704215302_vjlpa.jpg")
                    .into(viewHolder.imageView);
        }
        return view;
    }
}
