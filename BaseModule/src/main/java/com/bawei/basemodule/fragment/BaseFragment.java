package com.bawei.basemodule.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutView(), null);
        initView(view);
        initData();
        click();
        return view;
    }

    /**
     * 加载布局
     * */
    public abstract int getLayoutView();

    /**
     * 初始化控件方法
     * */
    public abstract void initView(View view);

    /**
     * 加载数据方法
     * */
    public abstract void initData();

    /**
     * 点击事件处理方法
     * */
    public abstract void click();
}
