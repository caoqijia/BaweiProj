package com.bawei.basemodule.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @author FreePay
 */
public abstract class BaseMVPActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        initView();
        initData();
        click();
    }

    /**
     * 加载布局
     * */
    public abstract int getLayoutView();

    /**
     * 初始化控件方法
     * */
    public abstract void initView();

    /**
     * 加载数据方法
     * */
    public abstract void initData();

    /**
     * 点击事件处理方法
     * */
    public abstract void click();
}
