package com.south.prefee.widget.mvvm.factory;

import com.south.prefee.widget.mvvm.model.BaseModel;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateModel {
    Class<? extends BaseModel> value();
}
