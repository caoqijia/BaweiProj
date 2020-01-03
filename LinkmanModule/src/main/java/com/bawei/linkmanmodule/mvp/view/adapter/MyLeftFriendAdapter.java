package com.bawei.linkmanmodule.mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.linkmanmodule.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class MyLeftFriendAdapter extends RecyclerView.Adapter<MyLeftFriendAdapter.MyViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> friend_list;

    public MyLeftFriendAdapter(Context context, ArrayList<HashMap<String, String>> friend_list) {
        this.context = context;
        this.friend_list = friend_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HashMap<String, String> map = friend_list.get(position);
        Glide.with(context).load(map.get("headerimg")).into(holder.imageView);
        holder.textView.setText(map.get("nick"));
    }

    @Override
    public int getItemCount() {
        return friend_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_friend_img);
            textView = itemView.findViewById(R.id.tv_friend_nick);
        }
    }
}
