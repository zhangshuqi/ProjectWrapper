package com.south.prefee.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.south.prefee.BR;


/**
 * Created by Administrator on 2017/9/19.
 */

public class FootRefreshBean extends BaseObservable {
    public void setStatus(int status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public int status;
    @Bindable
    public String text;
}
