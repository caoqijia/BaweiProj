package com.bawei.homemodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.bawei.homemodule.R;

/**
 * 底部交换自定义控件
 * */
public class SwitcherView extends LinearLayout {

    ImageView iv_linkman,iv_activity,iv_circle,iv_photo,iv_middle;

    public SwitcherView(Context context) {
        super(context);
        initView(context);
    }

    public SwitcherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SwitcherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.homemodule_switcherview_layout, this, true);
        iv_linkman = view.findViewById(R.id.iv_linkman);
        iv_activity = view.findViewById(R.id.iv_activity);
        iv_circle = view.findViewById(R.id.iv_circle);
        iv_photo = findViewById(R.id.iv_photo);
        iv_middle = view.findViewById(R.id.iv_middle);
    }

    public void clickLinkMan(){
        iv_linkman.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
