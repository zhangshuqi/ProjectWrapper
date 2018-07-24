package com.south.prefee.manager.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.south.prefee.http.ApiServer;
import com.south.prefee.http.Url;
import com.south.prefee.widget.retrofithelper.interceptor.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class RetrofitJsonManager extends RetrofitManager {


    private static class SingleHttpMethods {
        private static final RetrofitJsonManager INSTANCE = new RetrofitJsonManager();
    }

    //获取单例
    public static RetrofitJsonManager getInstance() {
        return SingleHttpMethods.INSTANCE;
    }

    private RetrofitJsonManager() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        NetworkInterceptor networkInterceptor = new NetworkInterceptor();
        networkInterceptor.setLevel(NetworkInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(networkInterceptor);
        httpClientBuilder.connectTimeout(12, TimeUnit.SECONDS);
        httpClientBuilder.retryOnConnectionFailure(true);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .client(httpClientBuilder.build())
                .build();
        apiService = retrofit.create(ApiServer.class);
    }


}
