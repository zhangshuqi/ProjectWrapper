package com.south.prefee.bean;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/31
 * @Describe
 */

public class ProcessStartSwitchFragmentEvent {
    public   int projectPosition;
    public   ProcessStartBean itemData;
    public int diskFolderId;
    public String name;

    public ProcessStartSwitchFragmentEvent(int id, String name) {
        this.diskFolderId = id;
        this.name = name;
    } public ProcessStartSwitchFragmentEvent(ProcessStartBean itemData, int projectPosition) {
       this.itemData =itemData;
       this.itemData.projectPosition=projectPosition;
    }
}
