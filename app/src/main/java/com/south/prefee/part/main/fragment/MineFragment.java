package com.south.prefee.part.main.fragment;

import com.south.prefee.R;
import com.south.prefee.part.main.viewmodel.MineFragmentViewModel;
import com.south.prefee.widget.mvvm.factory.CreateViewModel;
import com.south.prefee.widget.mvvm.view.BaseMVVMFragment;
import com.south.prefee.databinding.FragmentMineBinding;

@CreateViewModel(MineFragmentViewModel.class)
public class MineFragment extends BaseMVVMFragment<MineFragmentViewModel, FragmentMineBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
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