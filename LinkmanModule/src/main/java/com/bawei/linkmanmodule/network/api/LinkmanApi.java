package com.bawei.linkmanmodule.network.api;

import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.linkmanmodule.network.entity.FriendListEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LinkmanApi {
    /**
     * 通过code获取好友列表
     * */
    @GET("api/Friend/getFriends")
    Observable<BaseEntity<ArrayList<FriendListEntity>>> friendListReq(@Query("usercode")String usercode);
}
