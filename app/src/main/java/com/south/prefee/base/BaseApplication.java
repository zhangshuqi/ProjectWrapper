package com.south.prefee.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.south.prefee.db.DaoMaster;
import com.south.prefee.db.DaoSession;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.south.prefee.utils.db.DBDaoHelper;
import com.south.prefee.widget.ActivityLifecycleHelper;
import com.south.prefee.widget.pagemanage.PageManager;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/15
 * @Describe
 */

public class BaseApplication extends Application {
    private static Context mContext;
    private static DaoSession mDaoSession;
    private static DaoMaster daoMaster;
    private ActivityLifecycleHelper mActivityLifecycleHelper;
    private final static boolean isDebugMode = true;
    private static Handler mHandler;
    private static int mMainTreadId;
    protected RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        mMainTreadId = Process.myTid();
        mContext = getApplicationContext();
        initSQL();
        initLogger();
        initPageManager();
        registerActivityLifecycleCallbacks(mActivityLifecycleHelper = new ActivityLifecycleHelper());
        refWatcher= setupLeakCanary();
    }
    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication leakApplication = (BaseApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }

    private void initPageManager() {
        PageManager.initInApp(mContext);
    }

    private void initSQL() {
        getDaoSession();
    }

    private void initLogger() {
        if (isDebugMode) {
            Logger.init("TASK_MANAGE")
                    .methodCount(4)
                    .hideThreadInfo()
                    .logLevel(LogLevel.FULL);
        } else {
            Logger.init("TASK_MANAGE")
                    .methodCount(3)
                    .hideThreadInfo()
                    .logLevel(LogLevel.NONE);
        }
    }


    /**
     * 取得DaoMaster
     *
     * @return daoMaster
     */
    public static DaoMaster getDaoMaster() {

        DBDaoHelper helper = new DBDaoHelper(mContext, "south_prefee.db");
        daoMaster = new DaoMaster(helper.getWritableDatabase());

        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @return daoSession
     */
    public static DaoSession getDaoSession() {
        if (mDaoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            mDaoSession = daoMaster.newSession();

        }
        return mDaoSession;
    }


    public static Context getContext() {
        return mContext;
    }

    public ActivityLifecycleHelper getActivityLifecycleHelper() {
        return mActivityLifecycleHelper;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static long getMainTreadId() {
        return mMainTreadId;
    }
}
