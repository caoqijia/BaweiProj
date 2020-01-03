package com.bawei.linkmanmodule.mvp.view.fragment;

import android.view.View;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.basemodule.fragment.BaseFragment;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.mvp.contract.LinkmanContract;
import com.bawei.linkmanmodule.mvp.presenter.LinkmanPresenter;
import com.bawei.linkmanmodule.mvp.view.adapter.MyLeftFriendAdapter;
import com.bawei.linkmanmodule.mvp.view.adapter.MyRightLinkmanAdapter;
import com.bawei.linkmanmodule.network.entity.FriendListEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author FreePay
 */
public class FriendFragment extends BaseFragment implements LinkmanContract.ILinkmanView {

    String userCode;
    MyLeftFriendAdapter myLeftFriendAdapter;
    MyRightLinkmanAdapter myRightLinkmanAdapter;
    RecyclerView rv_friend_right,rv_friend_left;
    ArrayList<String> list = new ArrayList<>();
    LinkmanPresenter linkmanPresenter = new LinkmanPresenter();
    ArrayList<HashMap<String,String>> friend_List = new ArrayList<>();
    String str = "A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,S,Y,Z";

    public FriendFragment(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView(View view) {
        rv_friend_left = view.findViewById(R.id.rv_friend_left);
        rv_friend_right = view.findViewById(R.id.rv_friend_right);
    }

    /**
     * 调用加载方法
     * */
    @Override
    public void initData() {
        linkmanPresenter.attachView(this);
        linkmanPresenter.getFriendList(userCode);
        setRightData();
    }

    /**
     * 加载右侧数据方法
     * */
    private void setRightData() {
        String[] split = str.split(",");
        for (int i=0;i<split.length;i++){
            list.add(split[i]);
        }
        myRightLinkmanAdapter = new MyRightLinkmanAdapter(getContext(),list);
        rv_friend_right.setAdapter(myRightLinkmanAdapter);
        rv_friend_right.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_friend_right.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void click() {

    }

    @Override
    public void onSuccess(BaseEntity<ArrayList<FriendListEntity>> entity) {
        ArrayList<FriendListEntity> data = entity.getData();
        for (int i=0;i<data.size();i++){
            FriendListEntity friendListEntity = data.get(i);
            HashMap<String,String> map = new HashMap<>();
            String headerimg = friendListEntity.getHeaderimg();
            String usercode = friendListEntity.getUsercode();
            String nick = friendListEntity.getNick();
            map.put("headerimg",headerimg);
            map.put("usercode",usercode);
            map.put("nick",nick);
            friend_List.add(map);
        }
        myLeftFriendAdapter = new MyLeftFriendAdapter(getContext(),friend_List);
        rv_friend_left.setAdapter(myLeftFriendAdapter);
        rv_friend_left.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_friend_left.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onFiled(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public LifecycleOwner getOwner() {
        return this;
    }
}
