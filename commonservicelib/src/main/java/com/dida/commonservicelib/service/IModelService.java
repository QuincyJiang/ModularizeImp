/*
 * Created by QuincyJiang on 18-9-18 上午11:46
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午11:46
 */

package com.dida.commonservicelib.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IModelService extends IProvider {
    /**
     * 登录
     * */
    void login();
    /**
     * 登出
     * */
    void signOut();
    /**
     * 获取卫生间信息
     * */
    void getBathroomInfo();
    /**
     * 获取房屋信息
     * */
    void getHouseInfo();
    /**
     * 获取房屋租客信息
     * */
    void getHouseTenentInfo();
    /**
     * 每日签到
     * */
    void dailySignIn();
    /**
     * 获取用户信息
     * */
    void getUserInfo();
    /**
     * 获取卫生间使用状态
     * */
    void getBathroomStatus();
    /**
     * 设置卫生间状态为使用中
     * */
    void startToUse();
    /**
     * 设置卫生间状态为结束使用
     * */
    void finishUse();
    /**
     * 获取消息
     * */
    void getMessage();

}
