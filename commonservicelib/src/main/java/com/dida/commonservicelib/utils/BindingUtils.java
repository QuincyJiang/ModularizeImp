/*
 * Created by QuincyJiang on 18-9-9 下午5:53
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-7 下午10:10
 */

package com.dida.commonservicelib.utils;
import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by dxx on 2017/11/13.
 */

public class BindingUtils {

    @BindingAdapter("image")
    public static void loadImage(ImageView image, String uri){
        if(image!=null){
            Glide.with(image.getContext()).load(uri).into(image);
        }
    }

    @BindingAdapter("image")
    public static void loadImage(ImageView image, int id){
        if(image!=null){
            Glide.with(image.getContext()).load(id).into(image);
        }
    }

    @BindingAdapter("onNavigationItemSelectedListener")
    public static void setOnNavigationItemSelectedListener(
            BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter("viewPagerAdapter")
    public static void setViewPagerAdapter(ViewPager view, FragmentStatePagerAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

}
