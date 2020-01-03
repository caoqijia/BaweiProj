package com.bawei.linkmanmodule.mvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.mvp.view.activity.PhoneLinkmanActivity;
import com.bawei6.common.entity.LinkmanPhoneEntity;

import java.util.List;

public class MyLeftLinkmanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    PhoneLinkmanActivity phoneLinkmanActivity;
    List<LinkmanPhoneEntity> phoneInfo;

    public MyLeftLinkmanAdapter(PhoneLinkmanActivity phoneLinkmanActivity, List<LinkmanPhoneEntity> phoneInfo) {
        this.phoneLinkmanActivity = phoneLinkmanActivity;
        this.phoneInfo = phoneInfo;
    }

    @Override
    public int getItemViewType(int position) {
        return phoneInfo.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(phoneLinkmanActivity).inflate(R.layout.linkman_title_item, parent, false);
            return new MyTitleViewHolder(view);
        }else {
            View view = LayoutInflater.from(phoneLinkmanActivity).inflate(R.layout.linkman_phone_item, parent, false);
            return new MyPhoneViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinkmanPhoneEntity linkmanPhoneEntity = phoneInfo.get(position);
        if (linkmanPhoneEntity.getType()==0){
            ((MyTitleViewHolder)holder).tv_title.setText(linkmanPhoneEntity.getInitial());
        }else {
            ((MyPhoneViewHolder)holder).tv_name.setText(linkmanPhoneEntity.getName());
            ((MyPhoneViewHolder)holder).tv_phone.setText(linkmanPhoneEntity.getNumber());
        }
    }

    @Override
    public int getItemCount() {
        return phoneInfo.size();
    }

    class MyTitleViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        public MyTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_left_title);
        }
    }

    class MyPhoneViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_phone;
        public MyPhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_left_name);
            tv_phone = itemView.findViewById(R.id.tv_left_phone);
        }
    }
}
