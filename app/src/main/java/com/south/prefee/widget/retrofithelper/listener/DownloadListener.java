package com.south.prefee.widget.retrofithelper.listener;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/15
 * @Describe
 */

public interface DownloadListener {
    void onStartDownload();

    void onProgress(int progress);

    void onFinishDownload();

    void onFail(String errorInfo);
}
