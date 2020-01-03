package com.bawei.baweiproj.text;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> liveData = new MutableLiveData<>();
    public MutableLiveData<String> getLiveData(){
        return liveData;
    }
}
