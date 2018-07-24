package com.south.prefee.interfaces;

import com.south.prefee.bean.ProfileSelectionStaffLocalBean;

import java.util.List;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/16
 * @Describe
 */

public interface ProfileSelectionStaffFragmentClickListener {
    void  fragmentClickListener(List<ProfileSelectionStaffLocalBean> list, ProfileSelectionStaffLocalBean itemData);
    boolean isAddFragment(int tag);
}
