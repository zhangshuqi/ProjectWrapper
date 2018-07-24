package com.south.prefee.part.main.viewmodel;

import com.south.prefee.databinding.FragmentMineBinding;
import com.south.prefee.part.main.contract.MineFragmentContract;
import com.south.prefee.part.main.model.MineFragmentModel;
import com.south.prefee.widget.mvvm.factory.CreateModel;

@CreateModel(MineFragmentModel.class)
public class MineFragmentViewModel   extends MineFragmentContract.ViewModel<FragmentMineBinding>{
}
