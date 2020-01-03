package com.bawei.linkmanmodule.mvp.view.activity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.basemodule.widget.CustomTitleBar;
import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.mvp.view.adapter.MyLeftLinkmanAdapter;
import com.bawei.linkmanmodule.mvp.view.adapter.MyRightLinkmanAdapter;
import com.bawei6.common.utils.ContentProviderUtils;
import com.bawei6.common.entity.LinkmanPhoneEntity;

import java.util.ArrayList;
import java.util.List;

@Route(path = ValPool.SKIP_PHONE_LINKMAN)
public class PhoneLinkmanActivity extends BaseMVPActivity {

    CustomTitleBar phone_linkman_custom;
    RecyclerView rv_left,rv_right;
    List<LinkmanPhoneEntity> phoneInfo;
    MyRightLinkmanAdapter myRightLinkmanAdapter;
    MyLeftLinkmanAdapter myLeftLinkmanAdapter;
    ArrayList<String> list = new ArrayList<>();
    String str = "A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,S,Y,Z";

    /**
     * 加载布局文件
     * */
    @Override
    public int getLayoutView() {
        return R.layout.activity_phone_linkman;
    }

    /**
     * 初始化控件
     * */
    @Override
    public void initView() {
        rv_left = findViewById(R.id.rv_left);
        rv_right = findViewById(R.id.rv_right);
        phone_linkman_custom = findViewById(R.id.phone_linkman_custom);
    }

    /**
     * 调用加载方法
     * */
    @Override
    public void initData() {
        setRightData();
        setLeftData();
    }

    /**
     * 加载左侧数据方法
     * */
    private void setLeftData() {
        phoneInfo = ContentProviderUtils.getPhoneInfo(this);
        myLeftLinkmanAdapter = new MyLeftLinkmanAdapter(this,phoneInfo);
        rv_left.setAdapter(myLeftLinkmanAdapter);
        rv_left.setLayoutManager(new LinearLayoutManager(this));
        rv_left.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    /**
     * 加载右侧数据方法
     * */
    private void setRightData() {
        String[] split = str.split(",");
        for (int i=0;i<split.length;i++){
            list.add(split[i]);
        }
        myRightLinkmanAdapter = new MyRightLinkmanAdapter(this,list);
        rv_right.setAdapter(myRightLinkmanAdapter);
        rv_right.setLayoutManager(new LinearLayoutManager(this));
        rv_right.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    /**
     * 调用点击方法
     * */
    @Override
    public void click() {
        phone_linkman_custom.leftOnClick(view -> finish());
    }
}
