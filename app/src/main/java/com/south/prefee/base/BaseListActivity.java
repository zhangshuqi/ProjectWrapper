package com.south.prefee.base;

import com.south.prefee.R;
import com.south.prefee.bean.TestBean;
import com.south.prefee.databinding.ActivityBaseListBinding;
import com.south.prefee.view.recyclerView.RefreshRecyclerNetConfig;
import com.south.prefee.view.recyclerView.pagemanagestrategy.PageManageBuilder;
import com.south.prefee.widget.databindingadapter.SingleTypeBindingAdapter;
import com.south.prefee.widget.mvvm.view.BaseMVVMActivity;
import com.south.prefee.widget.mvvm.view.BaseMVVMView;
import com.south.prefee.widget.mvvm.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/22
 * @Describe
 */

public abstract class BaseListActivity< V extends BaseMVVMView, VM extends BaseViewModel > extends BaseMVVMActivity< VM, ActivityBaseListBinding> {

    protected SingleTypeBindingAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_list;
    }

    @Override
    public void initView() {
        List<TestBean> list = new ArrayList<>();
        TestBean bean = new TestBean();
        bean.text="1";
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        mAdapter = new SingleTypeBindingAdapter(this, list, getItemLayout());
        PageManageBuilder builder = new PageManageBuilder(this)
                .setAdapter(mAdapter);
        getBuilder(builder);
        mBinding.recyclerView.create(builder);
        mBinding.recyclerView.setLoadMoreAdapter(mAdapter);
        mBinding.recyclerView.setRefreshRecyclerNetConfig(getRefreshRecyclerNetConfig());
    }

    /**
     * 获取到retrofit访问api的配置
     * */
    protected abstract RefreshRecyclerNetConfig getRefreshRecyclerNetConfig();
    /**
     *  设置recyclerView的配置类
     * */
    protected   void getBuilder(PageManageBuilder builder){

    }
    /**
     *  获取到adapter的itemLayout
     * */
    protected abstract int getItemLayout();

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
