/*
 * Created by QuincyJiang on 18-9-18 上午11:34
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午11:05
 */

package com.dida.loginmodule.app;

import com.dida.commonservicelib.base.ApplicationLike;
import com.dida.commonservicelib.utils.AppUtils;
import com.dida.loginmodule.config.Config;

import cn.bmob.v3.Bmob;

public class LoginAppLike implements ApplicationLike {
    @Override
    public void onCreate() {
        Bmob.initialize(AppUtils.getContext(), Config.BMOB_APP_ID);
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
