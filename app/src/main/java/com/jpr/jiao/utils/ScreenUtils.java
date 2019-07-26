package com.jpr.jiao.utils;

import com.jpr.jiao.App;

/**
 * 类描述：屏幕信息工具类
 * 作者：jiaopeirong on 2019-07-26 23:08
 * 邮箱：chinajpr@163.com
 */
public class ScreenUtils {

    /**
     * 获取屏幕宽度
     * @return
     */
    public static int getScreenWidth(){
        return App.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getScreenHeight(){
        return App.getInstance().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * dp转px
     * @param dp
     * @return
     */
    public static int dp2px(int dp){
        return (int)(App.getInstance().getResources().getDisplayMetrics().density * dp);
    }
}
