package com.bawei.basemodule.network;

import com.bawei.basemodule.network.entity.TokenEntity;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TokenApi {

    /**
     * 请求Token
     * */
    @FormUrlEncoded
    @POST("token")
    Call<TokenEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);

}
