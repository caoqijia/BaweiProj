package com.bawei.baweiproj.mvp.contract;

import com.bawei.basemodule.contract.BasePresenter;
import com.bawei.basemodule.contract.IModel;
import com.bawei.basemodule.contract.IView;
import com.bawei.basemodule.network.entity.BaseEntity;
import com.bawei.baweiproj.network.entity.UserLoginReqEntity;
import com.bawei.baweiproj.network.entity.UserLoginReturnEntity;
import com.bawei.baweiproj.network.entity.UserRegisterReqEntity;

import io.reactivex.Observable;

/**
 * @author FreePay
 */
public interface UserContract {

    interface IUserView extends IView {
        void onSuccess(String msg);
        void onFailed(String msg);
        void onAuthCode(String code);
    }

    interface IUserModel extends IModel {
        Observable<BaseEntity<UserRegisterReqEntity>> register(UserRegisterReqEntity userRegisterReqEntity);
        Observable<BaseEntity<UserLoginReturnEntity>> login(UserLoginReqEntity userLoginReqEntity);
        Observable<BaseEntity<String>> authCode(String phone);
    }

    abstract class IUserPresenter<V extends IView,M extends IModel> extends BasePresenter<V,M>{
        public abstract void register(UserRegisterReqEntity userRegisterReqEntity);
        public abstract void login(UserLoginReqEntity userLoginReqEntity);
        public abstract void authCode(String username);
    }
}
