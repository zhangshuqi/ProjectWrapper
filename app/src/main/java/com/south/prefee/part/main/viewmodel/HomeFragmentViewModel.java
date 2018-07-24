package com.south.prefee.part.main.viewmodel;

import com.south.prefee.databinding.FragmentHomeBinding;
import com.south.prefee.part.main.contract.HomeFragmentContract;
import com.south.prefee.part.main.model.HomeFragmentModel;
import com.south.prefee.widget.mvvm.factory.CreateModel;

@CreateModel(HomeFragmentModel.class)
public class HomeFragmentViewModel  extends HomeFragmentContract.ViewModel<FragmentHomeBinding>{

}
