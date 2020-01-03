package com.bawei.linkmanmodule.mvp.view.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.network.entity.AddFriendWayEntity;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyAddFriendWayRecycleViewAdapter extends BaseQuickAdapter<AddFriendWayEntity, BaseViewHolder> {

    public MyAddFriendWayRecycleViewAdapter(int layoutResId, @Nullable List<AddFriendWayEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddFriendWayEntity item) {
        Glide.with(mContext).load(item.getPic()).into((ImageView) helper.getView(R.id.iv_find_people_title));
        helper.setText(R.id.tv_find_people_title,item.getTitle());
    }
}
