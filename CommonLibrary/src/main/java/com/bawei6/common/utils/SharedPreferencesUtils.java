package com.bawei6.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bawei.basemodule.val.ValPool;

public class SharedPreferencesUtils {

    private static SharedPreferences sharedPreferences;

    public static void putSharedPreferences(Context context,String key, String value){
        sharedPreferences = context.getSharedPreferences(ValPool.SP_NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getSharedPreferences(String key){
        String string = sharedPreferences.getString(key, "");
        return string;
    }
}
