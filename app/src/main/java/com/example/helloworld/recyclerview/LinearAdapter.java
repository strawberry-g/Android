package com.example.helloworld.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.helloworld.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context context;
    private ItemOnclickListener itemListener;
    private List<String> list;

    public LinearAdapter(Context context, ItemOnclickListener itemOnclickListener) {
        this.context = context;
        this.itemListener = itemOnclickListener;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("HelloWorld!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemListener.onClickListener(position);
                //Toast.makeText(context,"click..."+ position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
        //return list.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface ItemOnclickListener{
        void onClickListener(int position);
    }
}
