package com.south.prefee.interfaces;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/20
 * @Describe
 */

public abstract class RefreshRecyclerLoadListener<E> {
    public abstract void onSucceed(E _t, int action);


    public void onError(String errorInfo, int action) {

    }

    public void onError(String errorInfo, int errorCode, int action) {
        onError(errorInfo, action);
    }

    public void onEmpty(int action) {

    }

    public void onStart(int action) {

    }

    public void onRetry(int action) {

    }
}
