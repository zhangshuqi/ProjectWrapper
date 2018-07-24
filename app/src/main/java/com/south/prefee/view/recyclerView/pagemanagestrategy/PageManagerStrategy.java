package com.south.prefee.view.recyclerView.pagemanagestrategy;


import com.south.prefee.widget.mvvm.view.AppActivityManager;
import com.south.prefee.widget.pagemanage.PageManager;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/19
 * @Describe
 */

public class PageManagerStrategy extends LoadingManageStrategy {

    private PageManager mPageManager;

    public PageManagerStrategy(PageManageBuilder builder) {
        super(builder);
    }


    @Override
    public void showPageContent() {
        if (mPageManager != null) mPageManager.showContent();
    }

    @Override
    public void showPageLoading(String loadingMsg) {
        if (mPageManager == null) {
            mPageManager = PageManager.init(mBuilder.getRecyclerView().getParent(), mBuilder.getRetryMsg(), mBuilder.getEmptyMsg(), loadingMsg, new Runnable() {
                @Override
                public void run() {
                    if (mPageErrorRetryListener != null)
                        mPageErrorRetryListener.errorRetry();
                }
            });
        }
        if (mPageManager != null) {
            if (!PageManager.isNetWorkAvailable(mBuilder.getContext())) {
                PageManager.showNoNetWorkDlg(AppActivityManager.getAppActivityManager().currentActivity());
                mPageManager.showError();
            } else {
                mPageManager.showLoading(loadingMsg);
            }
        }
    }

    @Override
    public void showPageEmpty(String emptyMsg) {
        if (mPageManager != null) mPageManager.showEmpty(emptyMsg);
    }

    @Override
    public void showPageError(String errorMsg) {
        if (mPageManager != null) mPageManager.showError(errorMsg);
    }


}
