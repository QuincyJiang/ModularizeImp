/*
 * Created by QuincyJiang on 18-9-10 上午10:10
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-10 上午10:10
 */

package com.dida.commonservicelib.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 登录页面提供的公有服务
 * */
public interface ILoginService extends IProvider {
    /**
     * 获取登录状态
     * */
    boolean getLoginStatus();
    boolean isTokenExpire();
}
