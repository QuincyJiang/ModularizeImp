/*
 * Created by QuincyJiang on 18-9-9 下午5:01
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-9 下午5:01
 */

package com.dida.commonservicelib.path;

public class ARouterPath {
    /**
     * 页面路由表
     * */
    /**段子列表*/
    public static final String FUNNY_STORY_ACTIVITY = "/funny/activity/list";
    /**主页*/
    public static final String HOME_PAGE_ACTIVITY = "/homepage/activity/main";
    /**登录页面*/
    public static final String LOGIN_ACTIVITY_LOGIN = "/login/activity/login";
    /**注册页面*/
    public static final String LOGIN_ACTIVITY_REGISTER = "/login/activity/register";
    /**分享页面*/
    public static final String SHARE_ACTIVITY = "/share/activity/main";
    /**用户中心页面*/
    public static final String USER_CENTER_ACTIVITY = "/user/activity/main";

    /**
     * 服务路由表
     * */
    public static final String LOGIN_STATUS_SERVICE = "/login/service/status";
    public static final String CORE_MODEL_BASE_SERVICE = "/core/service/base";
}
