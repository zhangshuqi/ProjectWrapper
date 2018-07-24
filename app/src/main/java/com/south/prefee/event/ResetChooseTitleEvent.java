package com.south.prefee.event;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/5/9
 * @Describe
 */

public class ResetChooseTitleEvent {
    public Object project;

    public ResetChooseTitleEvent(Object project) {
        this.project = project;
    }
}
