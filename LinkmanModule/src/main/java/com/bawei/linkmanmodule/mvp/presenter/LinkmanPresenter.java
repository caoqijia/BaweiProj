package com.bawei.linkmanmodule.mvp.presenter;

import com.bawei.basemodule.network.BaseObserveable;
import com.bawei.basemodule.network.BaseObserver;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.linkmanmodule.mvp.contract.LinkmanContract;
import com.bawei.linkmanmodule.mvp.model.LinkmanModel;
import com.bawei.linkmanmodule.network.entity.FriendListEntity;

import java.util.ArrayList;

public class LinkmanPresenter extends LinkmanContract.LinkmanPresenter<LinkmanContract.ILinkmanView, LinkmanContract.ILinkmanModel> {

    LinkmanModel linkmanModel = new LinkmanModel();
    LinkmanContract.ILinkmanView iLinkmanView;

    @Override
    public void attachView(LinkmanContract.ILinkmanView iLinkmanView) {
        super.attachView(iLinkmanView);
        this.iLinkmanView = iLinkmanView;
    }

    @Override
    public void getFriendList(String userCode) {
        BaseObserveable.doObservable(linkmanModel.getFriendList(userCode),new BaseObserver<BaseEntity<ArrayList<FriendListEntity>>>(){
            @Override
            public void onNext(BaseEntity<ArrayList<FriendListEntity>> friendListEntityBaseEntity) {
                super.onNext(friendListEntityBaseEntity);
                iLinkmanView.onSuccess(friendListEntityBaseEntity);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                iLinkmanView.onFiled(e.getMessage());
            }
        },iLinkmanView.getOwner());
    }
}
