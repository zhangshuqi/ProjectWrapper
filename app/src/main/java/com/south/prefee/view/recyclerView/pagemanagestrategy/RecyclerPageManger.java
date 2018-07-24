package com.south.prefee.view.recyclerView.pagemanagestrategy;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/19
 * @Describe
 */

public class RecyclerPageManger {
    private PageManageBuilder builder;

    public LoadingManageStrategy getLoadingManageStrategy() {
        return pageManagerStrategy;
    }

    public void setPageManagerStrategy(LoadingManageStrategy pageManagerStrategy) {
        this.pageManagerStrategy = pageManagerStrategy;
    }

    private LoadingManageStrategy pageManagerStrategy;

    public void showContent() {
        if (builder.isNotShowPageManager()) return;
        pageManagerStrategy.showPageContent();
    }

    public void showPageLoading() {
        if (builder.isNotShowPageManager()) return;
        if (builder.isRefreshDataNotShowLoading()) return;
        pageManagerStrategy.showPageLoading(builder.loadingMsg);
    }

    public void showPageEmpty() {
        if (builder.isNotShowPageManager()) return;
        if (builder.isShowEmptyStatus()) {
            pageManagerStrategy.showPageEmpty(builder.emptyMsg);
        } else {
            pageManagerStrategy.showPageContent();
        }
    }

    public void showPageError() {
        if (builder.isNotShowPageManager()) return;
        if (builder.isShowErrorStatus()) {
            pageManagerStrategy.showPageError(builder.retryMsg);
        } else {
            pageManagerStrategy.showPageContent();
        }
    }



    public void setBuilder(PageManageBuilder builder) {
        if (builder == null) {
            return;
        }
        this.builder = builder;
    }


}
