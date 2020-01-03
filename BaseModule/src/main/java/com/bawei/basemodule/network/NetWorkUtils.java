package com.bawei.basemodule.network;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.bawei.basemodule.network.deviceInfo.AppInfoConfig;
import com.bawei.basemodule.network.deviceInfo.DeviceInfoConfig;
import com.bawei.basemodule.network.entity.TokenEntity;
import com.bawei.basemodule.val.ValPool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkUtils {

    private static OkHttpClient.Builder builder;
    private static Interceptor interceptor;
    /**
     * 获取Retrofit对象
     * */
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl(ValPool.BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * log打印网络请求拦截器
     * */
    private static Interceptor initLogInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }

    /**
     * 初始化OkHttpClient对象
     * */
    private static OkHttpClient initClient(){
        return  getOkHttpClient().addInterceptor(createRequestInterceptor())
                .addNetworkInterceptor(initLogInterceptor())
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3,TimeUnit.SECONDS)
                .connectTimeout(3,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 获取OkHttpClient创建者对象
     * */
    private static OkHttpClient.Builder getOkHttpClient(){
        if (builder==null){
            builder = new OkHttpClient.Builder();
        }
        return builder;
    }

    /**
     * 发送请求加上自己手机的参数
     * */
    private static Interceptor createRequestInterceptor() {
            interceptor = chain -> {
            Request request = chain.request();
            Response response = chain.proceed(request);

//          如果是401 重新同步请求Token然后加载到新请求的Hander里
            if (checkHttpCode401(response)) {
                String token = requestToken("341de11517517819a16213218f10712d1df1fa1221471591");
                Request newRequest = request
                        .newBuilder()
                        .addHeader("Content-Type", "application-json")
                        .addHeader("charset", "utf-8")
                        .addHeader("manufacturer", DeviceInfoConfig.getInstance().getMANUFACTURER())
                        .addHeader("model",DeviceInfoConfig.getInstance().getMODEL())
                        .addHeader("deviceid",DeviceInfoConfig.getInstance().getDeviceID())
                        .addHeader("utdid",DeviceInfoConfig.getInstance().getUtdid())
                        .addHeader("packagename", AppInfoConfig.getInstance().getPackageName())
                        .addHeader("versioncode",AppInfoConfig.getInstance().getVersionCode())
                        .addHeader("versionname",AppInfoConfig.getInstance().getVersionName())
                        .addHeader("location","")
                        .addHeader("macaddress",DeviceInfoConfig.getInstance().getMacAddress())
                        .addHeader("display",DeviceInfoConfig.getInstance().getDisplay())
                        .addHeader("osversion",DeviceInfoConfig.getInstance().getOSVersion())
                        .addHeader("Authorization", "bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
            return response;
        };
        return interceptor;
    }

    /**
     * 获取Token的同步网络请求
     */
    private static String requestToken(String authCode) {
        String access_token = null;
        try {
            TokenEntity password = NetWorkUtils.getRetrofit().create(TokenApi.class)
                    .getToken("password", authCode, "")
                    .execute().body();
            access_token = password.getAccess_token();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_token;
    }


    /**
     * 判断httpCode是否是401  ——  Token失效
     **/
    private static boolean checkHttpCode401(Response response) {
        if (response == null){
            return false;
        }
        if (response.code() == ValPool.TOKEN_LOSE){
            return true;
        }else {
            return false;
        }
    }
}
