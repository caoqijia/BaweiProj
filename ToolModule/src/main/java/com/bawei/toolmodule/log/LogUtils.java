package com.bawei.toolmodule.log;

import android.util.Log;

import com.bawei.basemodule.val.ValPool;

/**
 * Log打印工具类
 * */
public class LogUtils {
    public static void d(String msg){
        if (ValPool.LOG_CLOCK){
            Log.d(ValPool.TAG,msg);
        }
    }

    public static void e(String msg){
        if (ValPool.LOG_CLOCK){
            Log.e(ValPool.TAG,msg);
        }
    }

    public static void i(String msg){
        if (ValPool.LOG_CLOCK){
            Log.i(ValPool.TAG,msg);
        }
    }

    public static void v(String msg){
        if (ValPool.LOG_CLOCK){
            Log.v(ValPool.TAG,msg);
        }
    }
}
