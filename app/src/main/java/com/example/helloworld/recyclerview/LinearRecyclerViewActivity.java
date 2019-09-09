package com.example.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.example.helloworld.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        rvMain.addItemDecoration(new MyDecoration());
        rvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.ItemOnclickListener() {
            @Override
            public void onClickListener(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this,"click" + position,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //在下面加分割线
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
