package com.south.prefee.interfaces;

import com.south.prefee.bean.ProfileFileBean;

import java.util.List;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/12
 * @Describe
 */

public interface   UploadListener {
        void onUploadSuccess(List<ProfileFileBean> file);

      void onUploadFailed() ;

}
