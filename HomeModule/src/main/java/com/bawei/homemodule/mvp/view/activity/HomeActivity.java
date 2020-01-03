package com.bawei.homemodule.mvp.view.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.basemodule.widget.MapTitleBar;
import com.bawei.homemodule.R;
import com.bawei.homemodule.widget.SwitcherView;
import com.bawei6.common.utils.SharedPreferencesUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.wyp.avatarstudio.AvatarStudio;

/**
 * @author FreePay
 */
@Route(path = ValPool.SKIP_HOME)
public class HomeActivity extends BaseMVPActivity implements View.OnClickListener {

    ImageView iv_head_portrait,iv_close,iv_linkman,iv_activity,iv_middle,iv_photo,iv_circle;
    DrawerLayout drawerLayout;
    SwitcherView switcherView;
    MapTitleBar mapTitleBar;
    MapView mMapView;
    AMap aMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
        aMap = mMapView.getMap();
        aMap.getUiSettings().setZoomControlsEnabled(false);
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        iv_close = findViewById(R.id.iv_close);
        drawerLayout = findViewById(R.id.drawer);
        mapTitleBar = findViewById(R.id.home_custom_titleBar);
        iv_head_portrait = findViewById(R.id.iv_head_portrait);
        mMapView = findViewById(R.id.homemodule_mv_map);

        switcherView = findViewById(R.id.homemodule_sv_Switcher);
        iv_activity = switcherView.findViewById(R.id.iv_activity);
        iv_linkman = switcherView.findViewById(R.id.iv_linkman);
        iv_middle = switcherView.findViewById(R.id.iv_middle);
        iv_photo = switcherView.findViewById(R.id.iv_photo);
        iv_circle = switcherView.findViewById(R.id.iv_circle);
    }

    @Override
    public void initData() {
        Glide.with(this).load(R.drawable.head_portrait).apply(RequestOptions.circleCropTransform()).into(iv_head_portrait);
    }

    @Override
    public void click() {
        mapTitleBar.leftOnClick(view -> drawerLayout.openDrawer(Gravity.LEFT));
        mapTitleBar.rightOnClick(view -> {
            Intent intent = new Intent(this, CaptureActivity.class);
            startActivityForResult(intent, ValPool.REQUEST_CODE);
        });
        iv_head_portrait.setOnClickListener(this);
        iv_activity.setOnClickListener(this);
        iv_linkman.setOnClickListener(this);
        iv_close.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        //TODO 点击更换头像
        if (view.getId() == R.id.iv_head_portrait) {
            new AvatarStudio.Builder(HomeActivity.this)
                    .dimEnabled(true)
                    .needCrop(true)
                    .setAspect(1,1)
                    .setOutput(100,100)
                    .setTextColor(Color.BLACK)
                    .setText("相机","相册","取消")
                    .show(uri -> Glide.with(HomeActivity.this).load(uri).into(iv_head_portrait));
        //TODO 点击关闭侧滑抽屉
        }else if (view.getId() == R.id.iv_close){
            drawerLayout.closeDrawer(Gravity.LEFT);
        //TODO 点击跳转联系人界面
        }else if (view.getId() == R.id.iv_linkman){
            ARouter.getInstance().build(ValPool.SKIP_LINKMAN).navigation();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ValPool.REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
