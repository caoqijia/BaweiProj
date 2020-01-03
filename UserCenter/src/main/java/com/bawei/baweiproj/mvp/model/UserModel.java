package com.bawei.baweiproj.mvp.model;

import com.bawei.basemodule.network.NetWorkUtils;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.baweiproj.mvp.contract.UserContract;
import com.bawei.baweiproj.network.api.UserApi;
import com.bawei.baweiproj.network.entity.UserLoginReqEntity;
import com.bawei.baweiproj.network.entity.UserLoginReturnEntity;
import com.bawei.baweiproj.network.entity.UserRegisterReqEntity;

import io.reactivex.Observable;

public class UserModel implements UserContract.IUserModel {

    UserApi userApi = NetWorkUtils.getRetrofit().create(UserApi.class);

    /**
     * 注册请求
     * */
    @Override
    public Observable<BaseEntity<UserRegisterReqEntity>> register(UserRegisterReqEntity userRegisterReqEntity) {
        return userApi.registerReq(userRegisterReqEntity);
    }

    /**
     * 登录请求
     *
     * @return*/
    @Override
    public Observable<BaseEntity<UserLoginReturnEntity>> login(UserLoginReqEntity userLoginReqEntity) {
        return userApi.loginReq(userLoginReqEntity);
    }

    /**
     * 验证码请求
     * */
    @Override
    public Observable<BaseEntity<String>> authCode(String phone) {
        return userApi.getAuthCode(phone);
    }
}
