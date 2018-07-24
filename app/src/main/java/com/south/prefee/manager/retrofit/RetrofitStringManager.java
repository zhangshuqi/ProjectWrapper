package com.south.prefee.manager.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.south.prefee.http.ApiServer;
import com.south.prefee.http.Url;
import com.south.prefee.widget.retrofithelper.interceptor.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/13
 * @Describe
 */

public class RetrofitStringManager extends RetrofitManager {

    private static class SingleHttpMethods {
        private static final RetrofitStringManager INSTANCE = new RetrofitStringManager();
    }

    //获取单例
    public static RetrofitStringManager getInstance() {
        return RetrofitStringManager.SingleHttpMethods.INSTANCE;
    }

    private RetrofitStringManager() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        NetworkInterceptor networkInterceptor = new NetworkInterceptor();
        networkInterceptor.setLevel(NetworkInterceptor.Level.BODY);
        //    httpClientBuilder.addInterceptor(networkInterceptor);
        httpClientBuilder.connectTimeout(12, TimeUnit.SECONDS);
        httpClientBuilder.retryOnConnectionFailure(true);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .client(httpClientBuilder.build())
                .build();
        apiService = retrofit.create(ApiServer.class);
    }

}
