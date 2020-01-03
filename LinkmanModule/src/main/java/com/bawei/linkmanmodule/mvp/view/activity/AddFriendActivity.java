package com.bawei.linkmanmodule.mvp.view.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.basemodule.activity.BaseMVPActivity;
import com.bawei.basemodule.val.ValPool;
import com.bawei.linkmanmodule.R;
import com.bawei.linkmanmodule.mvp.view.adapter.MyAddFriendFragmentPagerAdapter;
import com.bawei.linkmanmodule.mvp.view.fragment.FindGroupFragment;
import com.bawei.linkmanmodule.mvp.view.fragment.FindPeopleFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

@Route(path = ValPool.SKIP_ADD_FRIEND)
public class AddFriendActivity extends BaseMVPActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment findPeopleFragment,findGroupFragment;
    ArrayList<Fragment> fragments = new ArrayList<>();
    MyAddFriendFragmentPagerAdapter myAddFriendFragmentPagerAdapter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_friend;
    }

    @Override
    public void initView() {
        tabLayout = findViewById(R.id.add_friend_tab);
        viewPager = findViewById(R.id.add_friend_viewpager);
    }

    @Override
    public void initData() {
        initFragment();
        myAddFriendFragmentPagerAdapter = new MyAddFriendFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myAddFriendFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        findPeopleFragment = new FindPeopleFragment();
        findGroupFragment = new FindGroupFragment();
        fragments.add(findPeopleFragment);
        fragments.add(findGroupFragment);
    }

    @Override
    public void click() {

    }
}
