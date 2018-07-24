package com.south.prefee.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.south.prefee.BR;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/21
 * @Describe
 */

public class LoadingDialogConfigBean extends BaseObservable {
    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }

    public void setUseBlur(boolean useBlur) {
        isUseBlur = useBlur;
    }

    @Bindable
    public String text;
    public boolean isCancel;
    public boolean isUseBlur=true;
}
