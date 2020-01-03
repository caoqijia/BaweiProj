package com.bawei.basemodule.network;

import androidx.lifecycle.LifecycleOwner;

import com.bawei.basemodule.network.entity.BaseEntity;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseObserveable {
    public static <T> void doObservable(Observable<T> observable, Observer<T> observer, LifecycleOwner lifecycleOwner){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }

    /**
     * 重载使用Merge合并操作符
     * */
    public static void doObservable(Observable observable1,Observable observable2, Observer observer, LifecycleOwner lifecycleOwner){
        Observable observable = Observable.merge(observable1, observable2);
        doObservable(observable,observer,lifecycleOwner);
    }
}


