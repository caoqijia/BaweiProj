package com.bawei.basemodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bawei.basemodule.R;


public class CustomTitleBar extends LinearLayout {

    ImageView ivCustomviewTitlebarLeft;
    TextView tvCustomviewTitlebarTitle;
    TextView tvCustomviewTitlebarRight;
    ImageView ivCustomviewTitlebarRight;

    public CustomTitleBar(Context context) {
        super(context);
    }

    public CustomTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.customview_titlebar, null);
        ivCustomviewTitlebarLeft = view.findViewById(R.id.iv_customview_titlebar_left);
        tvCustomviewTitlebarTitle = view.findViewById(R.id.tv_customview_titlebar_title);
        tvCustomviewTitlebarRight = view.findViewById(R.id.tv_customview_titlebar_right);
        ivCustomviewTitlebarRight = view.findViewById(R.id.iv_customview_titlebar_right);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);

        int titleName = typedArray.getResourceId(R.styleable.CustomTitleBar_titlebarName, 0);
        int leftSrc = typedArray.getResourceId(R.styleable.CustomTitleBar_leftSrc, 0);
        int rightSrc = typedArray.getResourceId(R.styleable.CustomTitleBar_rightSrc, 0);
        boolean isRightBoolean = typedArray.getBoolean(R.styleable.CustomTitleBar_rightTypeText, true);

        if (titleName!=0){
            tvCustomviewTitlebarTitle.setText(titleName);
        }
        if (leftSrc!=0){
            ivCustomviewTitlebarLeft.setImageResource(leftSrc);
        }
        if (rightSrc!=0){
            if (isRightBoolean){
                tvCustomviewTitlebarRight.setText(rightSrc);
                ivCustomviewTitlebarRight.setVisibility(GONE);
            }else {
                tvCustomviewTitlebarRight.setVisibility(GONE);
                ivCustomviewTitlebarRight.setImageResource(rightSrc);
            }

        }
        typedArray.recycle();
        this.addView(view);
    }

    /**
     * 左边的控件点击事件
     * */
    public void leftOnClick(OnClickListener listener){
        ivCustomviewTitlebarLeft.setOnClickListener(listener);
    }

    /**
     * 右边的图片控件点击事件
     * */
    public void rightIvOnClick(OnClickListener listener){
        ivCustomviewTitlebarRight.setOnClickListener(listener);
    }

    /**
     * 右边的文字控件点击事件
     * */
    public void rightTvOnClick(OnClickListener listener){
        tvCustomviewTitlebarRight.setOnClickListener(listener);
    }
}
