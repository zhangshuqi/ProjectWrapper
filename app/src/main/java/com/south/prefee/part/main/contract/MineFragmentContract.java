package com.south.prefee.part.main.contract;

import android.databinding.ViewDataBinding;

import com.south.prefee.widget.mvvm.model.BaseModel;
import com.south.prefee.widget.mvvm.view.BaseMVVMView;
import com.south.prefee.widget.mvvm.viewmodel.BaseViewModel;

public class MineFragmentContract {
    public abstract static class Model extends BaseModel {

    }

    public interface View<E> extends BaseMVVMView {

    }

    public abstract static class ViewModel< D extends ViewDataBinding> extends BaseViewModel<View, D, Model> {
    }

}
