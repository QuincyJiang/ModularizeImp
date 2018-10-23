package com.dida.funnystory;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dida.commonservicelib.base.BaseActivity;
import com.dida.commonservicelib.path.ARouterPath;
import com.dida.commonservicelib.service.ILoginService;
import com.dida.commonservicelib.utils.AppUtils;

import static com.dida.commonservicelib.path.ARouterPath.FUNNY_STORY_ACTIVITY;
import static com.dida.commonservicelib.path.ARouterPath.LOGIN_STATUS_SERVICE;

@Route(path = FUNNY_STORY_ACTIVITY)
public class FunnyStoryActivity extends BaseActivity {

    @Autowired(name = LOGIN_STATUS_SERVICE)
    ILoginService service;


    @Override
    protected int getContentResId() {
        return R.layout.mod_activity_funny;
    }

    @Override
    protected void initView() {
        Button bt = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppUtils.getContext(),service.getLoginStatus()+"",Toast.LENGTH_LONG).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(ARouterPath.LOGIN_ACTIVITY_LOGIN)
                        /**可以针对性跳转跳转动画*/
                        .withTransition(R.anim.activity_up_in, R.anim.activity_up_out)
                        .navigation(FunnyStoryActivity.this);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
