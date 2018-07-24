package com.south.prefee.bean;

import android.databinding.BaseObservable;

import java.io.File;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/11
 * @Describe
 */

public class ProfileFileBean extends BaseObservable {
    public String fileName;
    public String filePath;
    public int fileType;
    public long recordTime;
    public String fileId;
    public File file;
}
