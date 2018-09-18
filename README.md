# 项目结构说明：
采用项目组件化+组件内MVVM结构的开发方式，使用`travis`做持续集成服务。
通过配置 `/gradle.properties`的

```gradle
isModule = true/false
```
字段，来完成模块的 `module` 和 `library`形态切换。
组件均可单独调试编译，并以`library`方式最终集成在app中。

项目总共分为一下几个模块
* app 壳
* dependencylib 第三方依赖维护库，属于基础依赖库，只以库方式存在
* commonservicelib 为其他模块暴露公有服务，以及维护一些基类，常量类的库，属于基础依赖库，只以库方式存在。
* coremodelmodule 核心model模块，所有与数据交互相关的操作，都由该模块完成，包括但不限于获取网络请求，持久化本地，读取sp，读写数据库之类的。属于独立模块，可以在模块和库形态切换。
* homepagemodule 主页面模块，属于独立模块，可以在模块和库形态切换。
* loginmodule 注册/登录相关模块，维护注册，登录的一系列流程，属于独立模块，可以在模块和库形态切换。
* sharemodule 分享模块，属于独立模块，可以在模块和库形态切换。
* userpagemodule 用户中心模块，属于独立模块，可以在模块和库形态切换。
* funnystorymodule 段子模块，属于独立模块，可以在模块和库形态切换。

# 模块说明：
## app
app壳，只包含一个闪屏页，可以通过配置`gradle`依赖的方式，决定是否增加其他模块。

## DependencyLib
`DependencyLib` 是一个基础依赖库，始终以库的方式存在，不可以在库和模块形态之间切换。
它主要负责一些共用的第三方库的依赖维护，比如`retrofit2`，`rxjava2`之类的，通过`./versions.gradle` 来统一管理版本。
## CommonServiceLib
`CommonServiceLib` 是一个基础依赖库，始终以库的方式存在，不可以在库和模块形态之间切换。
### base/ApplicationLike.java
`Application`生命周期的接口，在应用的`Application`初始化的时候，会通过反射的方式，搜索所有该接口的实现类，并回调对应的方法。
其他模块在`library`形态下，如果想在`Application`的生命周期回调里做某些操作，可以实现该接口。写法可以参考`CoreModelModule`

### path/ARouterPath.java
`ARouter`的路由表，需要为其他模块提供跳转服务的，都需要在该类中声明自己的路由表。
`ARouter`的使用方法见[ARouter中文说明文档](https://github.com/alibaba/ARouter/blob/master/README_CN.md)

### service/*
其他模块可以向外提供的服务。
**该目录下的所有java文件均为接口。**其他模块如果有新的功能提供，在该目录下声明自己可以提供的服务以`IXXService`命名，
同时在自己对应的模块下，实现该接口。
写法可以参照 `LoginModule`

**ILoginService.java**

```java
/**
 * 登录页面提供的公有服务
 * */
public interface ILoginService extends IProvider {
    /**
     * 获取登录状态
     * */
    boolean getLoginStatus();
    boolean isTokenExpire();
}

```

**loginmodule/service/LoginServiceImp**

```java
@Route(path = LOGIN_STATUS_SERVICE, name = "获取登录状态")
public class LoginServiceImp implements ILoginService {
    @Override
    public void init(Context context) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public boolean isTokenExpire() {
        return false;
    }
}
```
### utils/*
工具类集合。
**注意：为了便于维护，除非必须要`Activity`类型的`Context`，其他`Context`一律通过`AppUtils.getContext()`获取**

## coreModelModule

核心`model`模块，所有与数据交互相关的操作，都由该模块完成，包括但不限于获取网络请求，持久化本地，读取sp，读写数据库之类的。
目前该模块可提供的功能包括：
```java
public interface IModelService extends IProvider {
    /**
     * 登录
     * */
    void login();
    /**
     * 登出
     * */
    void signOut();
    /**
     * 获取卫生间信息
     * */
    void getBathroomInfo();
    /**
     * 获取房屋信息
     * */
    void getHouseInfo();
    /**
     * 获取房屋租客信息
     * */
    void getHouseTenentInfo();
    /**
     * 每日签到
     * */
    void dailySignIn();
    /**
     * 获取用户信息
     * */
    void getUserInfo();
    /**
     * 获取卫生间使用状态
     * */
    void getBathroomStatus();
    /**
     * 设置卫生间状态为使用中
     * */
    void startToUse();
    /**
     * 设置卫生间状态为结束使用
     * */
    void finishUse();
    /**
     * 获取消息
     * */
    void getMessage();
}
```

