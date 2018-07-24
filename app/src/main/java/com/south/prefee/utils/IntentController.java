package com.south.prefee.utils;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.south.prefee.R;
import com.south.prefee.bean.LaunchDirectBean;
import com.south.prefee.bean.PerformanceDealtListBean;

import com.south.prefee.widget.BigImagePagerActivity;

import java.util.ArrayList;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/27
 * @Describe
 */

public class IntentController {

    public static void toBigImageActivity(FragmentActivity activity, ArrayList<String> list, int position, int type) {
        Intent intent = new Intent(activity, BigImagePagerActivity.class);
        intent.putStringArrayListExtra(BigImagePagerActivity.INTENT_IMG_URLS, list);
        intent.putExtra(BigImagePagerActivity.INTENT_POSITION, position);
        intent.putExtra(BigImagePagerActivity.INTENT_IAG_TYPE, type);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    public static void toBigImageNetActivity(FragmentActivity activity, String path, int position) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(path);
        toBigImageActivity(activity, strings, position, BigImagePagerActivity.TYPE_NET_IMAGE);
    }

    public static void toBigImageNetActivity(FragmentActivity activity, ArrayList<String> path, int position) {

        toBigImageActivity(activity, path, position, BigImagePagerActivity.TYPE_NET_IMAGE);
    }

    public static void toBigImageFileActivity(FragmentActivity activity, String path, int position) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(path);
        toBigImageActivity(activity, strings, position, BigImagePagerActivity.TYPE_FILE_IMAGE);
    }

    public static void toBigImageFileActivity(FragmentActivity activity, ArrayList<String> path, int position) {

        toBigImageActivity(activity, path, position, BigImagePagerActivity.TYPE_FILE_IMAGE);
    }


}
