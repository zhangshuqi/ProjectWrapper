package com.south.prefee.bean;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/20
 * @Describe
 */

public class BaseRequestData<T> {
    public int resultcode;
    public T datas;
    public String errormsg;
}
