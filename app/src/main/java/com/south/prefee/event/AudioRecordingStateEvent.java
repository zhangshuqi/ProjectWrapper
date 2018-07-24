package com.south.prefee.event;

import java.io.File;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/11
 * @Describe
 */

public class AudioRecordingStateEvent {
    public String viewTag;
    public int totalTime;
    public File audioFile;
    public boolean state;

    public AudioRecordingStateEvent(boolean b, File mAudioFile, int time, String viewTag) {
        this.state = b;
        this.audioFile = mAudioFile;
        this.totalTime = time;
        this.viewTag = viewTag;
    }
}
