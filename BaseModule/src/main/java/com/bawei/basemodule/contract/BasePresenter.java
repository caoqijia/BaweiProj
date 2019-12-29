package com.bawei.basemodule.contract;

public abstract class BasePresenter<V extends IModel,M extends IView> {
    protected V mIView;
    protected M mIModel;

    /**
     * 解绑View
     * */
    public void dettachView(){
        if (mIView!=null){
            mIView=null;
        }
    }
}
