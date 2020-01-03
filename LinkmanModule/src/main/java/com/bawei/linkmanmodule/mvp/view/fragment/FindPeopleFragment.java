package com.bawei.linkmanmodule.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.basemodule.fragment.BaseFragment;
import com.bawei.basemodule.val.ValPool;
import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.network.entity.AddFriendWayEntity;
import com.bawei.linkmanmodule.mvp.view.adapter.MyAddFriendWayRecycleViewAdapter;

import java.util.ArrayList;

public class FindPeopleFragment extends BaseFragment {

    SearchView searchView;
    RecyclerView rv_add_friend_way,rv_add_friends;
    ArrayList<AddFriendWayEntity> addFriendWayEntities = new ArrayList<>();
    MyAddFriendWayRecycleViewAdapter myAddFriendWayRecycleViewAdapter;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_find_people;
    }

    @Override
    public void initView(View view) {
        searchView = view.findViewById(R.id.sv_add_friend);
        rv_add_friend_way = view.findViewById(R.id.add_friend_way);
        rv_add_friends = view.findViewById(R.id.add_friends);
    }

    @Override
    public void initData() {
        addFriendWayEntities.add(new AddFriendWayEntity(R.drawable.phone,"添加手机联系人"));
        addFriendWayEntities.add(new AddFriendWayEntity(R.drawable.sao,"面对面加好友"));
        myAddFriendWayRecycleViewAdapter = new MyAddFriendWayRecycleViewAdapter(R.layout.add_friend_way_item,addFriendWayEntities);
        rv_add_friend_way.setAdapter(myAddFriendWayRecycleViewAdapter);
        rv_add_friend_way.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_add_friend_way.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void click() {
       myAddFriendWayRecycleViewAdapter.setOnItemClickListener((adapter, view, position) -> {
           if (position==0){
               ARouter.getInstance().build(ValPool.SKIP_PHONE_LINKMAN).navigation();
           }else if (position==1){

           }
       });
    }
}
