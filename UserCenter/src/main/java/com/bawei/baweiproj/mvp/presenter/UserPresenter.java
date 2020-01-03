package com.bawei.baweiproj.mvp.presenter;

import android.content.SharedPreferences;

import com.bawei.basemodule.network.BaseObserveable;
import com.bawei.basemodule.network.BaseObserver;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.baweiproj.mvp.contract.UserContract;
import com.bawei.baweiproj.mvp.model.UserModel;
import com.bawei.baweiproj.network.entity.UserLoginReqEntity;
import com.bawei.baweiproj.network.entity.UserLoginReturnEntity;
import com.bawei.baweiproj.network.entity.UserRegisterReqEntity;
import com.bawei6.common.utils.SharedPreferencesUtils;
import com.baweigame.xmpplibrary.XmppManager;
import io.reactivex.Observable;

public class UserPresenter extends UserContract.IUserPresenter<UserContract.IUserView, UserContract.IUserModel> {

    UserContract.IUserView userIView;
    UserModel userIModel = new UserModel();
    XmppManager xmppManager = XmppManager.getInstance();

    /**
     * 绑定View
     * */
    @Override
    public void attachView(UserContract.IUserView userIView) {
        super.attachView(userIView);
        this.userIView = userIView;
    }

    /**
     * 注册处理
     * */
    @Override
    public void register(UserRegisterReqEntity userRegisterReqEntity) {
        Observable<BaseEntity<UserRegisterReqEntity>> observable1 = userIModel.register(userRegisterReqEntity);
        BaseObserveable.doObservable(observable1,new BaseObserver<BaseEntity<UserRegisterReqEntity>>(){
            @Override
            public void onNext(BaseEntity<UserRegisterReqEntity> entity) {
                super.onNext(entity);
                xmppManager.getXmppUserManager().createAccount(userRegisterReqEntity.getUsername(), userRegisterReqEntity.getPwd());
                userIView.onSuccess(entity.getMsg());
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                userIView.onFailed(e.getMessage());
            }
        },userIView.getOwner());
    }

    /**
     * 登录处理
     * */
    @Override
    public void login(UserLoginReqEntity userLoginReqEntity) {
        Observable<BaseEntity<UserLoginReturnEntity>> observable1 = userIModel.login(userLoginReqEntity);
        BaseObserveable.doObservable(observable1,new BaseObserver<BaseEntity<UserLoginReturnEntity>>(){
            @Override
            public void onNext(BaseEntity<UserLoginReturnEntity> entity) {
                super.onNext(entity);
                if(xmppManager.getXmppUserManager().login(userLoginReqEntity.getUsername(), userLoginReqEntity.getPwd())){
                    userIView.onSuccess(entity.getMsg()+":"+entity.getData().getUsercode());
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                userIView.onFailed(e.getMessage());
            }
        },userIView.getOwner());
    }

    /**
     * 获取验证码处理
     * */
    @Override
    public void authCode(String username) {
        BaseObserveable.doObservable(userIModel.authCode(username), new BaseObserver<BaseEntity<String>>(){
            @Override
            public void onNext(BaseEntity<String> entity) {
                super.onNext(entity);
                userIView.onAuthCode(entity.getData());
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                userIView.onFailed(e.getMessage());
            }
        },userIView.getOwner());
    }
}
