package com.south.prefee.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.south.prefee.widget.mvvm.view.BaseMVVMActivity;
import com.south.prefee.widget.mvvm.viewmodel.BaseViewModel;
import com.south.prefee.widget.pagemanage.PageManager;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/16
 * @Describe
 */

public abstract class BasePageManageActivity<VM extends BaseViewModel, D extends ViewDataBinding> extends BaseMVVMActivity<VM, D> {


    protected PageManager mPageManage;

    @Override
    public void initView() {
        initPageManage();
    }

    private PageManager initPageManage() {
        if (getPageManagerView() == null) return null;
        if (mPageManage == null) {
            mPageManage = PageManager.init(getPageManagerView(), getRetryRunnable());
        }
        mPageManage.showLoading();
        return mPageManage;
    }

    private Runnable getRetryRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                // requestNetPageManager(sNetRequestConfig);
                requestNetData();
            }
        };
    }

    /**
     * 此方法一定要复写,表示页面第一次加载数据与加载失败时点击重试
     */
    protected abstract void requestNetData();

    /**
     * @return 显示loading error emtry 的范围
     */
    protected abstract View getPageManagerView();

}
