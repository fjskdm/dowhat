package com.example.lenovo.hello.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.hello.R;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private String[] data={"4","2","3","4"};
//    private String[] data;
//    private Object[] data1;
    private Context mContext;
    private LayoutInflater mLayoutINflater;


    public MyListAdapter(Context context){
        this.mContext = context;
        mLayoutINflater = LayoutInflater.from(context);
    }
    public MyListAdapter(Context context,String[] data1){
        this.data = data1;
        this.mContext = context;
        mLayoutINflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
        public ImageView imageView;
        public TextView TV_title,TV_time,TV_show;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView = mLayoutINflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_1);
            holder.TV_title = convertView.findViewById(R.id.tv_title);
            holder.TV_time = convertView.findViewById(R.id.tv_time);
            holder.TV_show = convertView.findViewById(R.id.tv_show);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.TV_title.setText();

        holder.TV_title.setText(data[position]);
        holder.TV_show.setText("2018-7-20");
        holder.TV_show.setText("给你看看");
        Glide.with(mContext).load("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super").into(holder.imageView);
        return convertView;
    }
}
