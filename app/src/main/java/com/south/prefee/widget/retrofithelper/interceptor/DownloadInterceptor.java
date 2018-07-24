package com.south.prefee.widget.retrofithelper.interceptor;

import com.south.prefee.widget.retrofithelper.listener.DownloadListener;
import com.south.prefee.widget.retrofithelper.responsebody.DownloadResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/15
 * @Describe
 */

public class DownloadInterceptor  implements Interceptor {

    private DownloadListener downloadListener;

    public DownloadInterceptor(DownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(
                new DownloadResponseBody(response.body(), downloadListener)).build();
    }
}
