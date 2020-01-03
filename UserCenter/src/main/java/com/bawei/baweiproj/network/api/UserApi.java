package com.bawei.baweiproj.network.api;


import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.baweiproj.network.entity.UserLoginReqEntity;
import com.bawei.baweiproj.network.entity.UserLoginReturnEntity;
import com.bawei.baweiproj.network.entity.UserRegisterReqEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {

    /**
     * 注册用户
     * */
    @POST("api/User/register")
    Observable<BaseEntity<UserRegisterReqEntity>> registerReq(@Body UserRegisterReqEntity entity);

    /**
     * 登录用户
     * */
    @POST("api/User/login")
    Observable<BaseEntity<UserLoginReturnEntity>> loginReq(@Body UserLoginReqEntity entity);

    /**
     * 获取验证码
     * */
    @GET("api/User/getAuthCode")
    Observable<BaseEntity<String>> getAuthCode(@Query("phoneNumber") String phoneNumber);
}
