package com.bawei.homemodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.bawei.homemodule.R;

/**
 * 底部交换自定义控件
 * */
public class SwitcherView extends LinearLayout {

    public SwitcherView(Context context) {
        super(context);
    }

    public SwitcherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public SwitcherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.homemodule_switcherview_layout, this, true);
    }
}
