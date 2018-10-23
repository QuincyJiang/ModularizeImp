/*
 * Created by QuincyJiang on 18-9-18 上午11:34
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午11:34
 */

package com.dida.loginmodule.model;

import cn.bmob.v3.BmobObject;

public class Person extends BmobObject {
    private String name;
    private String adder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }
}
