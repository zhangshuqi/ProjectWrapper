package com.south.prefee.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/5/31
 * @Describe
 */

public class NegativeListBean {

    public NegativeListBean(String title) {
        this.title = title;
    }

    public String title;

    public static List getNegativeListData() {
        List negativeListData = new ArrayList();
        negativeListData.add(new NegativeListBean("高速公路项目交工检测质量"));
        negativeListData.add(new NegativeListBean("高速公路项目竣工鉴定质量"));
        negativeListData.add(new NegativeListBean("检测从业机构管理标准"));
        negativeListData.add(new NegativeListBean("公路工程工地试验室及现场检测项目评价标准"));
        return negativeListData;
    }
}
