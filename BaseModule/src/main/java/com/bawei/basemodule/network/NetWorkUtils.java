package com.bawei.basemodule.network;

import com.bawei.basemodule.val.ValPool;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author FreePay
 * @date 2019/12/27 16:20
 */
public class NetWorkUtils {

    private OkHttpClient.Builder builder;
    /**
     * 获取Retrofit对象
     * */
    public Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl(ValPool.BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * log打印网络请求拦截器
     * */
    private Interceptor initLogInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }

    /**
     * 初始化OkHttpClient对象
     * */
    private OkHttpClient initClient(){
        return  getOkHttpClient().addNetworkInterceptor(initLogInterceptor())
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3,TimeUnit.SECONDS)
                .connectTimeout(3,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 获取OkHttpClient创建者对象
     * */
    private OkHttpClient.Builder getOkHttpClient(){
        if (builder==null){
            builder = new OkHttpClient.Builder();
        }
        return builder;
    }
}
