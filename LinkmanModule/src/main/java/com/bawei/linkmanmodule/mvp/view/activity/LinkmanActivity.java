package com.bawei.linkmanmodule.mvp.view.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.basemodule.widget.CustomTitleBar;
import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.mvp.view.adapter.MyLinkmanFragmentPagerAdapter;
import com.bawei.linkmanmodule.mvp.view.fragment.FriendFragment;
import com.bawei.linkmanmodule.mvp.view.fragment.GroupChatFragment;
import com.bawei.linkmanmodule.mvp.view.fragment.GroupFragment;
import com.bawei6.common.utils.SharedPreferencesUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * @author FreePay
 */
@Route(path = ValPool.SKIP_LINKMAN)
public class LinkmanActivity extends BaseMVPActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    CustomTitleBar linkman_custom;
    ArrayList<Fragment> fragments = new ArrayList<>();
    Fragment friendFragment,groupFragment,groupChatFragment;
    MyLinkmanFragmentPagerAdapter myLinkmanFragmentPagerAdapter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_linkman;
    }

    @Override
    public void initView() {
        tabLayout = findViewById(R.id.linkman_tab);
        viewPager = findViewById(R.id.linkman_viewpager);
        linkman_custom = findViewById(R.id.linkman_custom);
    }

    @Override
    public void initData() {
        initFragment();
        myLinkmanFragmentPagerAdapter = new MyLinkmanFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myLinkmanFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        String userCode = SharedPreferencesUtils.getSharedPreferences("userCode");
        friendFragment = new FriendFragment(userCode);
        groupFragment = new GroupFragment();
        groupChatFragment = new GroupChatFragment();
        fragments.add(friendFragment);
        fragments.add(groupFragment);
        fragments.add(groupChatFragment);
    }

    @Override
    public void click() {
        linkman_custom.leftOnClick(view -> finish());
        linkman_custom.rightIvOnClick(view -> ARouter.getInstance().build(ValPool.SKIP_ADD_FRIEND).navigation());
    }
}
