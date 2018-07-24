package com.south.prefee.widget.mvvm.factory;

import com.south.prefee.widget.mvvm.model.BaseModel;

/**
 * 适用注解模式创建ViewModel
 */

public class ModelFactoryImpl< M extends BaseModel> implements ModelFactory<M> {
    private Class<M> mModel;

    public static <  M extends BaseModel  > ModelFactoryImpl createModelFactory(Class<?> viewClazz) {
        CreateModel annotation = viewClazz.getAnnotation(CreateModel.class);
        if (annotation != null) {
            Class<M> modelClazz = (Class<M>) annotation.value();
            try {
                return new ModelFactoryImpl(modelClazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {

            throw new NullPointerException("model 创建失败, 请查看view 模块是否添加了@CreateModel(xx.class) 注解");
        }
        return null;
    }

    private ModelFactoryImpl(Class<M> model) {
        this.mModel = model;
    }

    @Override
    public M createModel() {
        try {
            return mModel.newInstance();
        } catch (Exception e) {
            throw new NullPointerException("model 创建失败, 请查看view 模块是否添加了@CreateModel(xx.class) 注解");
        }
    }

}
