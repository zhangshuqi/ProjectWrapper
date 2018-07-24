package com.south.prefee.part.main.viewmodel;

import com.south.prefee.databinding.ActivityMainBinding;
import com.south.prefee.part.main.contract.MainContract;
import com.south.prefee.part.main.model.MainModel;
import com.south.prefee.widget.mvvm.factory.CreateModel;

@CreateModel(MainModel.class)
public class MainViewModel  extends MainContract.ViewModel<ActivityMainBinding>{
}
