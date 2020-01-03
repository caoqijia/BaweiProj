package com.bawei.basemodule.contract;

public abstract class BasePresenter<IView,IModel> {
    IView mView;
    IModel mModel;

    /**
     * 绑定View
     * */
    public void attachView(IView view){

    }

    /**
     * 解绑View
     * */
    public void dettachView(){
        if (mModel!=null){
            mModel=null;
        }
    }
}
