package com.bawei.basemodule.val;

/**
 * @author FreePay
 * 常量池
 **/
public class ValPool {

    /**
     * 后台服务器地址
     * */
    public static final String BASE_URL = "http://api.zydeveloper.com:10001/";
    /**
     * Token失效返回值
     * */
    public static final int TOKEN_LOSE = 401;
    /**
     * ZXing请求返回值
     * */
    public static final int REQUEST_CODE = 101;
    /**
     * SharedPreferences存储名
     * */
    public static final String SP_NAME = "cqj";
    /**
     * 打印标识
     * */
    public static final String TAG = "cqj";
    /**
     * Log打印开关
     * */
    public static final Boolean LOG_CLOCK = true;
    /**
     * 跳转到登录主界面
     * */
    public static final String SKIP_LOGIN = "/Login/LoginActivity";
    /**
     * 跳转到通讯IM主界面
     * */
    public static final String SKIP_HOME = "/Home/HomeActivity";
    /**
     * 跳转到注册界面
     * */
    public static final String SKIP_REGISTER = "/Register/RegisterActivity";
    /**
     * 跳转到通讯IM联系人界面
     * */
    public static final String SKIP_LINKMAN = "/Linkman/LinkmanActivity";
    /**
     * 跳转到通讯IM添加好友界面
     * */
    public static final String SKIP_ADD_FRIEND = "/AddFriend/AddFriendActivity";
    /**
     * 跳转手机联系人界面
     * */
    public static final String SKIP_PHONE_LINKMAN = "/PhoneLinkman/PhoneLinkmanActivity";
}
