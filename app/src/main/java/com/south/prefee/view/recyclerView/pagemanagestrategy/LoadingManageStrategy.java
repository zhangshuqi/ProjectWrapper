package com.south.prefee.view.recyclerView.pagemanagestrategy;

import com.south.prefee.interfaces.PageErrorRetryListener;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/19
 * @Describe
 */

public abstract class LoadingManageStrategy {


    protected PageManageBuilder mBuilder;
    protected PageErrorRetryListener mPageErrorRetryListener;

    public LoadingManageStrategy(PageManageBuilder builder) {
        this.mBuilder = builder;
    }


    // void retryAction();

    public abstract void showPageContent();

    public abstract void showPageLoading(String loadingMsg);

    public abstract void showPageEmpty(String emptyMsg);

    public abstract void showPageError(String errorMsg);

    public void setBuilder(PageManageBuilder builder) {
        this.mBuilder = builder;
    }
    public void setPageErrorRetryListener(PageErrorRetryListener listener){
            this.mPageErrorRetryListener =listener;
    }
}
