/*
 * Created by QuincyJiang on 18-9-9 下午5:16
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-9 下午10:10
 */
package com.dida.commonservicelib.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dida.commonservicelib.utils.AppUtils;
import com.dida.commonservicelib.utils.ClassUtils;

import java.util.List;


/**
 * BaseApplication 基类
 * 遍历所有实现的ApplicationLike接口实现对模块application生命周期的通知
 * */
public class BaseApplication extends Application {
    public static final String ROOT_PACKAGE = "com.guiying.module";
    private static BaseApplication APP_INSTANCE;
    private List<ApplicationLike> mAppLikeList;

    public static BaseApplication getInstance() {
        return APP_INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        APP_INSTANCE = this;/*        Logger.init("pattern").logLevel(LogLevel.FULL);*/
        AppUtils.init(this);
        mAppLikeList = ClassUtils.getObjectsWithInterface(this, ApplicationLike.class, ROOT_PACKAGE);
        for (ApplicationLike delegate : mAppLikeList) delegate.onCreate();
        initARouter();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (ApplicationLike delegate : mAppLikeList) delegate.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (ApplicationLike delegate : mAppLikeList) delegate.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (ApplicationLike delegate : mAppLikeList) delegate.onTrimMemory(level);
    }
    private void initARouter(){
            if (AppUtils.isAppDebug()) {
                ARouter.openDebug();
                ARouter.openLog();
            }
            ARouter.init(this);
    }
}
