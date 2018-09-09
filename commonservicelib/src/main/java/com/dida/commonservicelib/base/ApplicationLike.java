/*
 * Created by QuincyJiang on 18-9-9 下午5:11
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-7 下午10:10
 */

package com.dida.commonservicelib.base;

/**
 * Application 的声明周期代理接口
 * 各模块可以自己实现此接口以实现对整个应用application声明周期的通知
 * */

public interface ApplicationLike {

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
