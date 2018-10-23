package com.dida.sharemodule.app;

import com.dida.commonservicelib.base.ApplicationLike;
import com.dida.commonservicelib.base.Constants;
import com.dida.commonservicelib.utils.AppUtils;

import cn.bmob.v3.Bmob;

/**
 * Created by QuincyJiang at 2018/10/23 .
 * Description:
 * 正式环境会被壳app的Application回调 在这里初始化一下Bmob
 * 目前回调接口还是用的反射查找的方式，后期会使用编译期注解来动态创建代码
 */
public class MyApp implements ApplicationLike{
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