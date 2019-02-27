package com.example.lenovo.hello.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.hello.R;

import java.util.List;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder>{
    private Context mContext;
    private List<String> list;
    public PuAdapter(Context context) {
        this.mContext = context;
    }
    @NonNull
    @Override
    public PuAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 == 0){
            holder.imageView.setImageResource(R.drawable.withoutcheck);
        }else{
            holder.imageView.setImageResource(R.drawable.longit);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"click+"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_1);
        }
    }
}


