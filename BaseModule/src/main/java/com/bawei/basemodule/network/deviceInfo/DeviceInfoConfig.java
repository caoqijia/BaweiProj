package com.bawei.basemodule.network.deviceInfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

public class DeviceInfoConfig {
    private static DeviceInfoConfig instance;
    private DeviceInfoConfig(){}

    public static DeviceInfoConfig getInstance(){
        if (null==instance){
            synchronized (DeviceInfoConfig.class){
                if (null==instance){
                    return instance = new DeviceInfoConfig();
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
     * 获取厂商信息
     * */
    public String getMANUFACTURER(){
        return Build.MANUFACTURER;
    }

    /**
     * 获取机型信息
     * */
    public String getMODEL(){
        return Build.MODEL;
    }

    /**
     * Android 系统版本
     * */
    public String getOSVersion(){
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    /**
     * 获取设备号 包括：GMS - IMEI CDMA - MEID
     * */
    public String getDeviceID(){
        if (Build.VERSION.SDK_INT<23){
        }else {
            String deviceid = getIMEI();
            if (TextUtils.isEmpty(deviceid)){
                deviceid = getMEID();
            }
            return deviceid;
        }
        return "";
    }

    /**
     * 获取MEID
     * */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    private String getMEID(){
//        return_home UMUtils.getUMId(mContext);
        return "";
    }

    /**
     * 获取IMEI
     * */
    private String getIMEI(){
//        return_home UMUtils.getImsi(mContext);
        return "";
    }

    /**
     * 获取Utdid
     * */
    public String getUtdid() {
//       return_home UMUtils.getUTDID(mContext);
        return "";
    }

    /**
     * 获取物理地址
     * */
    public String getMacAddress(){
//        return_home UMUtils.getMac(mContext);
        return "";
    }

    /**
     * 获取屏幕分辨率
     * */
    public String getDisplay(){
//        return_home UMUtils.getDisplayResolution(mContext);
        return "";
    }

    /**
     * 获取位置
     * */
    @SuppressLint("MissingPermission")
    public String getLocation(){
        LocationManager systemService = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        Location location = systemService.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return String.valueOf(location.getLatitude())+ location.getLatitude();
    }
}
