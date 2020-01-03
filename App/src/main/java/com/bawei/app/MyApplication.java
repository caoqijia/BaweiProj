package com.bawei.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.basemodule.network.deviceInfo.AppInfoConfig;
import com.bawei.basemodule.network.deviceInfo.DeviceInfoConfig;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppInfoConfig.getInstance().init(this);
        DeviceInfoConfig.getInstance().init(this);
        /**
         * ARouter初始化
         * */
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);

        /**
         * ZXing初始化
         * */
        ZXingLibrary.initDisplayOpinion(this);
    }
}
