package com.gaoyanpeng.androidtestjob.second;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gaoyanpeng.androidtestjob.MainAdapter;
import com.gaoyanpeng.androidtestjob.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 高研鹏 on 2016/11/12.
 */

public class SecondAdaper extends RecyclerView.Adapter<SecondAdaper.NewViewHolder> {
    private Context context;
    private SecondBean mBean;
    private ArrayList<Integer> height;
    private Click mClick;

    public SecondAdaper setClick(Click click) {
        mClick = click;
        return this;
    }

    public SecondAdaper(Context context) {
        this.context = context;
    }

    public SecondAdaper setBean(SecondBean bean) {
        mBean = bean;
        height = new ArrayList<>();
        for (int i = 0; i < mBean.getData().getItems().size(); i++) {
            Random random = new Random();
            int heights = random.nextInt(800-400+1)+400;
            height.add(heights);
        }
        notifyDataSetChanged();
        return this;
    }

    @Override
    public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_second,parent,false);
        NewViewHolder holder = new NewViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewViewHolder holder, final int position) {
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        params.height = height.get(position);
        holder.imageView.setLayoutParams(params);
        Picasso.with(context).load(mBean.getData().getItems().get(position).getCover_image_url()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondAty.class);
                String urlB = mBean.getData().getItems().get(position).getPurchase_url();
                Log.d("SecondAdaper", "kakj"+urlB);
                intent.putExtra("urlB",urlB);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mBean.getData().getItems().size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public NewViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.se_image);
        }
    }
}
