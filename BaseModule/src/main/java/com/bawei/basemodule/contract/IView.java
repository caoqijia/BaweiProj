package com.bawei.basemodule.contract;

import androidx.lifecycle.LifecycleOwner;

/**
 * @author FreePay
 */
public interface IView {
    /**
     * 显示加载进度条
     * */
    void showLoading();

    /**
     * 隐藏加载进度条
     * */
    void hideLoading();
    /**
     *  生命周期所有者
     * */
    LifecycleOwner getOwner();
}
