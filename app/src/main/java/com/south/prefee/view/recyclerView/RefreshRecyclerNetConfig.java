package com.south.prefee.view.recyclerView;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/20
 * @Describe
 */

public abstract class RefreshRecyclerNetConfig {
    public abstract Observable getNetObservable(Map<String, Object> map);
}
