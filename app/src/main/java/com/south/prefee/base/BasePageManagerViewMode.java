package com.south.prefee.base;

import android.databinding.ViewDataBinding;

import com.south.prefee.interfaces.BasePageManageView;
import com.south.prefee.widget.mvvm.model.BaseModel;
import com.south.prefee.widget.mvvm.viewmodel.BaseViewModel;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/11
 * @Describe
 */

public class BasePageManagerViewMode<V extends BasePageManageView, D extends ViewDataBinding, M extends BaseModel> extends BaseViewModel<V, D, M> {
    
}
