/*
 * Created by QuincyJiang on 18-9-18 上午11:34
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午11:05
 */

package com.dida.coremodelmodule.app;

import com.dida.commonservicelib.base.ApplicationLike;
import com.dida.commonservicelib.base.Constants;
import com.dida.commonservicelib.utils.AppUtils;

import cn.bmob.v3.Bmob;

public class CoreModelAppLike implements ApplicationLike {
    @Override
    public void onCreate() {
        Bmob.initialize(AppUtils.getContext(), Constants.APPLICATION_ID);
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
