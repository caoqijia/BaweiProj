package com.bawei.toolmodule.deviceInfo;

import android.content.Context;
import android.content.pm.PackageManager;

public class AppInfoConfig {
    private static AppInfoConfig instance;
    private AppInfoConfig(){}

    public static AppInfoConfig getInstance(){
        if (null==instance){
            synchronized (AppInfoConfig.class){
                if (null==instance){
                    return instance = new AppInfoConfig();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     * */
    private Context mContext;
    public void init(Context context){
        mContext = context;
    }

    /**
     *获取PackageName
     * */
    public String getPackageName(){
        try {
            PackageManager packageManager = mContext.getPackageManager();
            return packageManager.getPackageInfo(mContext.getPackageName(),0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *获取VersionName
     * */
    public String getVersionName(){
        try {
            PackageManager packageManager = mContext.getPackageManager();
            return packageManager.getPackageInfo(mContext.getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *获取VersionCode
     * */
    public String getVersionCode(){
        try {
            PackageManager packageManager = mContext.getPackageManager();
            return String.valueOf(packageManager.getPackageInfo(mContext.getPackageName(),0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
