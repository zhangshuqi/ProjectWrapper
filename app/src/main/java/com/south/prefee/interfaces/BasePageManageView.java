package com.south.prefee.interfaces;


import com.south.prefee.widget.mvvm.view.BaseMVVMView;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/16
 * @Describe
 */

public interface BasePageManageView<E> extends BaseMVVMView {

    void showError(String message, int code);

    void showLoading(String message);

    void showContent(E data);

    void showEmpty(String empty);

}
