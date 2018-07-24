package com.south.prefee.base;

import com.south.prefee.R;
import com.south.prefee.databinding.FragmentBaseListBinding;
import com.south.prefee.view.recyclerView.RefreshRecyclerNetConfig;
import com.south.prefee.view.recyclerView.pagemanagestrategy.PageManageBuilder;
import com.south.prefee.widget.databindingadapter.SingleTypeBindingAdapter;
import com.south.prefee.widget.mvvm.view.BaseMVVMFragment;
import com.south.prefee.widget.mvvm.viewmodel.BaseViewModel;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/28
 * @Describe
 */

public abstract class BaseListFragment< VM extends BaseViewModel> extends BaseMVVMFragment<VM, FragmentBaseListBinding> {
    protected SingleTypeBindingAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_list;
    }

    @Override
    public void initView() {

        mAdapter = new SingleTypeBindingAdapter(mActivity, null, getItemLayout());
        PageManageBuilder builder = new PageManageBuilder(mActivity)
                .setAdapter(mAdapter);
        getBuilder(builder);
        mBinding.recyclerView.create(builder);
        mBinding.recyclerView.setLoadMoreAdapter(mAdapter);
        mBinding.recyclerView.setRefreshRecyclerNetConfig(getRefreshRecyclerNetConfig());
    }

    /**
     * 获取到retrofit访问api的配置
     */
    protected abstract RefreshRecyclerNetConfig getRefreshRecyclerNetConfig();

    /**
     * 设置recyclerView的配置类
     */
    protected void getBuilder(PageManageBuilder builder) {

    }

    /**
     * 获取到adapter的itemLayout
     */
    protected abstract int getItemLayout();

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
