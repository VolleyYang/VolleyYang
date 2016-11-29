package com.gaoyanpeng.androidtestjob.first.select;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoyanpeng.androidtestjob.R;
import com.squareup.picasso.Picasso;

/**
 * Created by 高研鹏 on 2016/11/11.
 */

public class SelectAdapter extends BaseAdapter{
    private Context mContext;
    private SelectBean mSelectBean;

    public SelectAdapter(Context context) {
        mContext = context;
    }

    public SelectAdapter setSelectBean(SelectBean selectBean) {
        mSelectBean = selectBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return mSelectBean.getData().getItems().size();
    }

    @Override
    public Object getItem(int position) {
        return mSelectBean.getData().getItems().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.iten_select,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (mSelectBean.getData().getItems().get(position).getAd_type() != 1){
            Picasso.with(mContext).load(mSelectBean.getData().getItems().get(position).getAuthor().getAvatar_url()).into(holder.avatar_url);
            holder.nickname.setText(mSelectBean.getData().getItems().get(position).getAuthor().getNickname());
            holder.introduction.setText(mSelectBean.getData().getItems().get(position).getAuthor().getIntroduction());
            Picasso.with(mContext).load(mSelectBean.getData().getItems().get(position).getCover_image_url()).into(holder.cover_image_url);
            holder.title.setText(mSelectBean.getData().getItems().get(position).getTitle());
            holder.share_msg.setText(mSelectBean.getData().getItems().get(position).getShare_msg());
            holder.number.setText(mSelectBean.getData().getItems().get(position).getLikes_count()+"");

        }


        return convertView;
    }
    class ViewHolder{
        private ImageView avatar_url,cover_image_url;
        private TextView nickname,introduction,title,share_msg,number;
        public ViewHolder(View view) {
            avatar_url = (ImageView) view.findViewById(R.id.select_title_head);
            nickname = (TextView) view.findViewById(R.id.se_title);
            introduction = (TextView) view.findViewById(R.id.se_title_content);
            cover_image_url = (ImageView) view.findViewById(R.id.se_content_image);
            title = (TextView) view.findViewById(R.id.se_title_big);
            share_msg = (TextView) view.findViewById(R.id.se_all_contact);
            number = (TextView) view.findViewById(R.id.number);
        }
    }
}
