package com.bawei.linkmanmodule.mvp.contract;

import com.bawei.basemodule.contract.BasePresenter;
import com.bawei.basemodule.contract.IModel;
import com.bawei.basemodule.contract.IView;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.linkmanmodule.network.entity.FriendListEntity;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface LinkmanContract {
    interface ILinkmanModel extends IModel{
        Observable<BaseEntity<ArrayList<FriendListEntity>>> getFriendList(String userCode);
    }
    interface ILinkmanView extends IView{
        void onSuccess(BaseEntity<ArrayList<FriendListEntity>> entity);
        void onFiled(String msg);
    }
    abstract class LinkmanPresenter<V extends IView,M extends IModel> extends BasePresenter<V,M>{
        public abstract void getFriendList(String userCode);
    }
}
