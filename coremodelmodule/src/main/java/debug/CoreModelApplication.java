/*
 * Created by QuincyJiang on 18-9-18 上午11:01
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午11:01
 */

package debug;

import com.dida.commonservicelib.base.BaseApplication;
import com.dida.commonservicelib.base.Constants;
import com.dida.commonservicelib.utils.AppUtils;

import cn.bmob.v3.Bmob;

public class CoreModelApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(AppUtils.getContext(), Constants.APPLICATION_ID);
    }
}
