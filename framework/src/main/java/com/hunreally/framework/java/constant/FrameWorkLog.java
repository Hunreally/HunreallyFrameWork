package com.hunreally.framework.java.constant;

import android.util.Log;

import com.hunreally.framework.BuildConfig;

/**
 * Created by Hunreally on 2018/6/15 0015.
 */
public class FrameWorkLog {

    private static final String TAG="FrameWorkLog";

    public static void L(String message){
        if (BuildConfig.DEBUG){
            //如果是debug模式才打印log
            //因为一些机型不输出debug级别的log，所以直接选用error级别的log
            Log.e(TAG,message);
        }
    }

    public static void l(String message){
        if (BuildConfig.DEBUG){
            //如果是debug模式才打印log
            //因为一些机型不输出debug级别的log，所以直接选用error级别的log
            Log.e(TAG,message);
        }
    }

    public static void L(String tag,String message){
        if (BuildConfig.DEBUG){
            //如果是debug模式才打印log
            //因为一些机型不输出debug级别的log，所以直接选用error级别的log
            Log.e(tag,message);
        }
    }
}
