package com.south.prefee.interfaces;

import com.south.prefee.bean.ProfileFileBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/11
 * @Describe
 */

public abstract class ChooseFileListener {
    public void onFile(ProfileFileBean profileFileBean,String tag) {
        List<ProfileFileBean> beans = new ArrayList<>();
        beans.add(profileFileBean);
        onFile(profileFileBean,tag);
    }

    public abstract void onFile(List<ProfileFileBean> profileFileBean,String tag);


    public abstract void onOpenFile(String viewTag);
}
