package com.south.prefee.manager.retrofit;

import com.south.prefee.http.ApiServer;

import retrofit2.Retrofit;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/13
 * @Describe
 */

public class RetrofitManager {
    public ApiServer apiService;

    public ApiServer getApiService() {
        return apiService;
    }

    public Retrofit retrofit;
}
