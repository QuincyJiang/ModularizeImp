/*
 * Created by QuincyJiang on 18-9-18 上午10:56
 * Copyright © 2018. All rights reserved.
 *
 * Last modified 18-9-18 上午10:56
 */

package com.dida.coremodelmodule;

import android.view.View;
import android.widget.Button;

import com.dida.commonservicelib.base.BaseActivity;
import com.dida.commonservicelib.utils.ToastUtil;
import com.dida.loginmodule.model.Person;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int getContentResId() {
        return R.layout.core_model_activity_main;
    }

    @Override
    protected void initView() {
        Button addData = $(R.id.button);
        Button getData = $(R.id.button2);
        Button modifyData = $(R.id.button3);
        Button deleteData = $(R.id.button4);
        addData.setOnClickListener(this);
        getData.setOnClickListener(this);
        modifyData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
    }
    @Override
    protected void initData() {

    }

    private String ID = "";
    @Override
    public void onClick(View v) {
        int id = v.getId();
       if(id == R.id.button){
           Person p = new Person();
           p.setAdder("Guangzhou");
           p.setName("Liming");
           p.save(new SaveListener<String>() {
               @Override
               public void done(String s, BmobException e) {
                   ToastUtil.getInstance().showToast("添加成功");
                   ID = s;
               }
           });
       }
       if(id == R.id.button2){
           BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
           bmobQuery.getObject(ID, new QueryListener<Person>() {
               @Override
               public void done(Person object,BmobException e) {
                   if(e==null){
                       ToastUtil.getInstance().showToast("查询成功");
                   }else{
                       ToastUtil.getInstance().showToast("查询失败：" + e.getMessage());
                   }
               }
           });
       }
       if(id == R.id.button3){
           final  Person p2 = new Person();
           p2.setAdder("北京朝阳");
           p2.update(ID, new UpdateListener() {

               @Override
               public void done(BmobException e) {
                   if(e==null){
                       ToastUtil.getInstance().showToast("更新成功:"+p2.getUpdatedAt());
                   }else{
                       ToastUtil.getInstance().showToast("更新失败：" + e.getMessage());
                   }
               }
           });
       }
       if(id == R.id.button4){
           final Person p2 = new Person();
           p2.setObjectId(ID);
           p2.delete(new UpdateListener() {

               @Override
               public void done(BmobException e) {
                   if(e==null){
                       ToastUtil.getInstance().showToast("删除成功:"+p2.getUpdatedAt());
                   }else{
                       ToastUtil.getInstance().showToast("删除失败：" + e.getMessage());
                   }
               }

           });
       }
    }
}
