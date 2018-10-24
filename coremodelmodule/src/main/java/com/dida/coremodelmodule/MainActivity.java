/*
 * Created by QuincyJiang on 18-9-18 上午10:56
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午10:56
 */

package com.dida.coremodelmodule;

import android.view.View;

import com.dida.commonservicelib.base.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int getContentResId() {
        return R.layout.core_model_activity_main;
    }

    @Override
    protected void initView() {

    }
    @Override
    protected void initData() {

    }

    private String ID = "";
    @Override
    public void onClick(View v) {
    }
}
