package com.bawei.linkmanmodule.mvp.model;

import com.bawei.basemodule.network.NetWorkUtils;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.linkmanmodule.mvp.contract.LinkmanContract;
import com.bawei.linkmanmodule.network.api.LinkmanApi;
import com.bawei.linkmanmodule.network.entity.FriendListEntity;

import java.util.ArrayList;

import io.reactivex.Observable;

public class LinkmanModel implements LinkmanContract.ILinkmanModel {

    LinkmanApi linkmanApi = NetWorkUtils.getRetrofit().create(LinkmanApi.class);

    /**
     * 获取好友列表
     * */
    @Override
    public Observable<BaseEntity<ArrayList<FriendListEntity>>> getFriendList(String userCode) {
        return linkmanApi.friendListReq(userCode);
    }
}
