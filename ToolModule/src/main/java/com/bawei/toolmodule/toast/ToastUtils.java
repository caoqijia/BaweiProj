package com.bawei.toolmodule.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * */
public class ToastUtils {

    /**
     * 吐司内容
     * */
    public static void showMsg(Context context,String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
