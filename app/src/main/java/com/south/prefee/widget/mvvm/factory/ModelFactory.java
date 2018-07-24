package com.south.prefee.widget.mvvm.factory;

import com.south.prefee.widget.mvvm.model.BaseModel;

/**
 * 创建viewModel的工厂
 */

public interface ModelFactory<M extends BaseModel> {
    /**
     * 创建ViewModel 的工厂方法,(由于不是所有的ViewModel 都适用于注解模式生成ViewModel对象,所以传入一个基类工厂,获取到ViewModel)
     *
     * @return 返回viewmodel
     */

    M createModel();
}
