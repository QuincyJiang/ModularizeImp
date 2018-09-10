/*
 * Created by QuincyJiang on 18-9-10 上午10:13
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-10 上午10:13
 */

package com.dida.loginmodule.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dida.commonservicelib.service.ILoginService;

import static com.dida.commonservicelib.path.ARouterPath.LOGIN_STATUS_SERVICE;

@Route(path = LOGIN_STATUS_SERVICE, name = "获取登录状态")
public class LoginServiceImp implements ILoginService {
    @Override
    public void init(Context context) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }
}
