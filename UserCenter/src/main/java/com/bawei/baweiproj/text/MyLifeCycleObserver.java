package com.bawei.baweiproj.text;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.bawei6.common.utils.LogUtils;

public class MyLifeCycleObserver implements LifecycleObserver {

    private Lifecycle lifecycle;

    public MyLifeCycleObserver(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    public void created(){
        LogUtils.d("Listener create...");
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    public void startd(){
        LogUtils.d("Listener start...");
    }
}
