package com.south.prefee.event;

import com.south.prefee.bean.ProfileSelectionStaffLocalBean;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/17
 * @Describe
 */

public class ProfileSelectionStaffLocalEvent {
    public ProfileSelectionStaffLocalBean mProfileSelectionStaffLocalBean;
    public String mViewTag;
    public String showName;

    public ProfileSelectionStaffLocalEvent(ProfileSelectionStaffLocalBean itemData, String mViewTag,String showName) {
        this.mViewTag = mViewTag;
        this.mProfileSelectionStaffLocalBean = itemData;
        this.showName = showName;
    }
}
