package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by wuhaiyang on 2015/8/10.
 * myframework
 */
public class TweenAnimLoadingLayout extends LoadingLayout {
    private AnimationDrawable animationDrawable;

    public TweenAnimLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);


        ll_right.setVisibility(GONE);
        FrameLayout.LayoutParams layoutParams = (LayoutParams) fl_left.getLayoutParams();
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        fl_left.setLayoutParams(layoutParams);

        // 初始化
        mHeaderImage.setImageResource(R.drawable.loading);
        animationDrawable = (AnimationDrawable) mHeaderImage.getDrawable();
    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.app_loading0;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    @Override
    protected void pullToRefreshImpl() {

    }

    @Override
    protected void refreshingImpl() {
// 播放帧动画
        animationDrawable.start();
    }

    @Override
    protected void releaseToRefreshImpl() {

    }

    @Override
    protected void resetImpl() {
        mHeaderImage.clearAnimation();
        mHeaderImage.setVisibility(View.VISIBLE);
    }
}
