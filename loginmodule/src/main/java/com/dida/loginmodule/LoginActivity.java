package com.dida.loginmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import static com.dida.commonservicelib.path.ARouterPath.LOGIN_ACTIVITY_LOGIN;

@Route(path = LOGIN_ACTIVITY_LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod_activity_login);
    }
}
