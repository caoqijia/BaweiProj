package com.bawei6.common.utils;

import android.util.Log;

import com.bawei.basemodule.val.ValPool;

public class LogUtils {

    public static void d(String log){
        if (ValPool.LOG_CLOCK){
            Log.d(ValPool.TAG,log);
        }
    }
    public static void i(String log){
        if (ValPool.LOG_CLOCK){
            Log.i(ValPool.TAG,log);
        }
    }
    public static void w(String log){
        if (ValPool.LOG_CLOCK){
            Log.w(ValPool.TAG,log);
        }
    }
    public static void e(String log){
        if (ValPool.LOG_CLOCK){
            Log.e(ValPool.TAG,log);
        }
    }
    public static void v(String log){
        if (ValPool.LOG_CLOCK){
            Log.v(ValPool.TAG,log);
        }
    }
}
