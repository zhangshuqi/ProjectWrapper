package com.south.prefee.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.south.prefee.BR;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/28
 * @Describe
 */

public class TestBean extends BaseObservable {
    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String text;


}
