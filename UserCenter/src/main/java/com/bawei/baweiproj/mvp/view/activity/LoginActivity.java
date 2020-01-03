package com.bawei.baweiproj.mvp.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.baweiproj.R;
import com.bawei.baweiproj.mvp.contract.UserContract;
import com.bawei.baweiproj.mvp.presenter.UserPresenter;
import com.bawei.baweiproj.network.entity.UserLoginReqEntity;
import com.bawei.baweiproj.text.MyLifeCycleObserver;
import com.bawei6.common.utils.LogUtils;
import com.bawei6.common.utils.SharedPreferencesUtils;
import com.bawei6.common.utils.ToastUtils;

/**
 * @author FreePay
 */
@Route(path = ValPool.SKIP_LOGIN)
public class LoginActivity extends BaseMVPActivity implements UserContract.IUserView,View.OnClickListener {

    TextView tv_register;
    Button bt_login;
    EditText et_username,et_password;
    UserPresenter userPresenter = new UserPresenter();

    @Override
    public int getLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        userPresenter.attachView(this);
        getLifecycle().addObserver(new MyLifeCycleObserver(getLifecycle()));
        bt_login = findViewById(R.id.bt_login);
        tv_register = findViewById(R.id.tv_register);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
    }

    @Override
    public void initData() {

    }

    @Override
    public void click() {
        tv_register.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_register) {
            ARouter.getInstance().build(ValPool.SKIP_REGISTER).navigation();
        } else if (id == R.id.bt_login) {
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                ToastUtils.showMsg(this, "不能为空");
                return;
            }
            userPresenter.login(new UserLoginReqEntity(username, password));
        }
    }

    @Override
    public void onSuccess(String msg) {
        String lock = "用户登录成功";
        String[] split = msg.split(":");
        SharedPreferencesUtils.putSharedPreferences(this,"userCode",split[1]);
        if (split[0].equals(lock)){
            ARouter.getInstance().build(ValPool.SKIP_HOME).navigation();
            finish();
        }
    }

    @Override
    public void onFailed(String msg) {
        LogUtils.d(msg);
    }

    @Override
    public void onAuthCode(String code) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public LifecycleOwner getOwner() {
        return this;
    }
}
