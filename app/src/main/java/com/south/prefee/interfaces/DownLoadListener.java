package com.south.prefee.interfaces;

import java.io.File;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/12
 * @Describe
 */

public abstract class DownLoadListener {
    public void onPaused() {
    }

    public void onRunning() {
    }

    public void onPending() {
    }

    public abstract void onSuccess(File file);

    public abstract void onFailed();
}
