package com.south.prefee.widget.mvvm;

import io.reactivex.disposables.Disposable;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/13
 * @Describe
 */

public interface DisposableLifeCycleListener {
    boolean addRxStop(Disposable disposable);

    boolean addRxDestroy(Disposable disposable);

    void remove(Disposable disposable);

    boolean isStopRxJava();
}
