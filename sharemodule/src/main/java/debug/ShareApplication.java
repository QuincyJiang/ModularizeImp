package debug;

import com.dida.commonservicelib.base.BaseApplication;
import com.dida.commonservicelib.base.Constants;
import com.dida.commonservicelib.utils.AppUtils;

import cn.bmob.v3.Bmob;

public class ShareApplication extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(AppUtils.getContext(), Constants.APPLICATION_ID);
    }
}
