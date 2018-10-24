package debug;

import com.dida.commonservicelib.base.BaseApplication;
import com.dida.commonservicelib.utils.AppUtils;
import com.dida.loginmodule.config.Config;

import cn.bmob.v3.Bmob;

public class LoginApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(AppUtils.getContext(), Config.BMOB_APP_ID);
    }
}
