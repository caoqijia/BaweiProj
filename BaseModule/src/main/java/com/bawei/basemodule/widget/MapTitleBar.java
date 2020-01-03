package com.bawei.basemodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;

import com.bawei.basemodule.R;

public class MapTitleBar extends LinearLayout {

    ImageView ivCustomviewTitlebarLeft;
    SearchView svCustomviewTitlebarSearchView;
    ImageView ivCustomviewTitlebarRight;

    public MapTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public MapTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.map_titlebar, this,true);
        ivCustomviewTitlebarLeft = view.findViewById(R.id.iv_customview_titlebar_left);
        svCustomviewTitlebarSearchView = view.findViewById(R.id.sv_customview_titlebar_searchview);
        ivCustomviewTitlebarRight = view.findViewById(R.id.iv_customview_titlebar_right);
    }

    /**
     * 左边的控件点击事件
     * */
    public void leftOnClick(View.OnClickListener listener){
        ivCustomviewTitlebarLeft.setOnClickListener(listener);
    }

    /**
     * 右边的控件点击事件
     * */
    public void rightOnClick(View.OnClickListener listener){
        ivCustomviewTitlebarRight.setOnClickListener(listener);
    }
}
