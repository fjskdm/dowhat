package com.example.lenovo.hello.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.hello.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder>{
    private Context mContext;
    private List<String> list;
    public LinearAdapter(Context context) {
        this.mContext = context;
    }
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));}
        else {
            return  new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item1,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        if(getItemViewType(position)==0){
            holder.textview.setText("hello world");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"click+"+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            holder.textview.setText("Hello world");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"click+"+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;
        public LinearViewHolder(View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.TV_1);
        }
    }
}


