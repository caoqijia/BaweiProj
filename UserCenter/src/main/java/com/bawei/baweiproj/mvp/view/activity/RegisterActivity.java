package com.bawei.baweiproj.mvp.view.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.LifecycleOwner;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.baweiproj.R;
import com.bawei.baweiproj.mvp.contract.UserContract;
import com.bawei.baweiproj.mvp.presenter.UserPresenter;
import com.bawei.baweiproj.network.entity.UserRegisterReqEntity;
import com.bawei6.common.utils.ToastUtils;

/**
 * @author FreePay
 */
@Route(path = ValPool.SKIP_REGISTER)
public class RegisterActivity extends BaseMVPActivity implements UserContract.IUserView,View.OnClickListener {

    EditText et_register_phone,et_register_yzm_pd,et_register_password,et_register_password_again;
    Button bt_send_yzm,bt_register_yes;
    UserPresenter userPresenter = new UserPresenter();
    NotificationManager notificationManager;
    String code = null;

    @Override
    public int getLayoutView(){
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        userPresenter.attachView(this);
        et_register_phone = findViewById(R.id.et_register_phone);
        et_register_yzm_pd = findViewById(R.id.et_register_yzm_pd);
        et_register_password = findViewById(R.id.et_register_password);
        et_register_password_again = findViewById(R.id.et_register_password_again);
        bt_send_yzm = findViewById(R.id.bt_send_yzm);
        bt_register_yes = findViewById(R.id.bt_register_yes);
    }

    @Override
    public void initData() {
    }

    @Override
    public void click() {
        bt_send_yzm.setOnClickListener(this);
        bt_register_yes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_send_yzm) {
            String phone = et_register_phone.getText().toString();
            if (phone.trim().isEmpty()) {
                ToastUtils.showMsg(this, "不能为空");
                return;
            }
            userPresenter.authCode(phone);
        } else if (id == R.id.bt_register_yes) {
            String username = et_register_phone.getText().toString();
            String yzm = et_register_yzm_pd.getText().toString();
            String password = et_register_password.getText().toString();
            String password_again = et_register_password_again.getText().toString();
            if (username.trim().isEmpty() || yzm.trim().isEmpty() || password.trim().isEmpty() || password_again.trim().isEmpty()) {
                ToastUtils.showMsg(this, "不能为空");
                return;
            }
            if (!password.equals(password_again)) {
                ToastUtils.showMsg(this, "两次密码不同");
                return;
            }
            if (!yzm.equals(code)) {
                ToastUtils.showMsg(this, "验证码有误");
                return;
            }
            userPresenter.register(new UserRegisterReqEntity(username, password));
        }
    }

    @Override
    public void onSuccess(String msg) {
        ToastUtils.showMsg(this,msg);
        String lock = "注册成功";
        if (msg.equals(lock)){
            finish();
        }else {
            et_register_password.setText("");
            et_register_password_again.setText("");
        }
    }

    @Override
    public void onFailed(String msg) {
        ToastUtils.showMsg(this,msg);
    }

    @Override
    public void onAuthCode(String code) {
        this.code = code;
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

//     获得验证码发送通知
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("收到的验证码信息")
                .setContentText("验证码为："+code)
                .build();
        notificationManager.notify(1,notification);
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
