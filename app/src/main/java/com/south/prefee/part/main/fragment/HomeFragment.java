package com.south.prefee.part.main.fragment;

import com.south.prefee.R;
import com.south.prefee.databinding.FragmentHomeBinding;
import com.south.prefee.part.main.contract.HomeFragmentContract;
import com.south.prefee.part.main.viewmodel.HomeFragmentViewModel;
import com.south.prefee.widget.mvvm.factory.CreateViewModel;
import com.south.prefee.widget.mvvm.view.BaseMVVMFragment;

@CreateViewModel(HomeFragmentViewModel.class)
public class HomeFragment extends BaseMVVMFragment<HomeFragmentViewModel, FragmentHomeBinding> implements HomeFragmentContract.View {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

}
