package com.south.prefee.part.main.activity;

import android.support.v4.app.Fragment;

import com.south.prefee.R;
import com.south.prefee.base.BaseFragmentAdapter;
import com.south.prefee.part.main.fragment.HomeFragment;
import com.south.prefee.part.main.fragment.MineFragment;
import com.south.prefee.part.main.viewmodel.MainViewModel;
import com.south.prefee.widget.mvvm.factory.CreateViewModel;
import com.south.prefee.widget.mvvm.view.BaseMVVMActivity;
import com.south.prefee.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

@CreateViewModel(MainViewModel.class)
public class MainActivity extends BaseMVVMActivity<MainViewModel,ActivityMainBinding> {


    private List<Fragment> mFragmentList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        HomeFragment homeFragment = new HomeFragment();
        MineFragment mineFragment = new MineFragment();
        mFragmentList = new ArrayList<>();
        mFragmentList.add(homeFragment);
        mFragmentList.add(mineFragment);
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mBinding.vpContent.setAdapter(adapter);
        mBinding.bbl.setViewPager(mBinding.vpContent);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    protected boolean isSupportSlideBack() {
        return false;
    }
}
