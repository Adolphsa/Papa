package com.lucas.architecture.ui.page;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kunminx.architecture.ui.page.DataBindingActivity;
import com.lucas.architecture.domain.manager.NetworkStateManager;
import com.lucas.architecture.utils.AdaptScreenUtils;
import com.lucas.architecture.utils.BarUtils;
import com.lucas.architecture.utils.ScreenUtils;

/**
 * Created by lucas
 * Date: 2020/9/25 14:40
 */
public abstract class BaseActivity extends DataBindingActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);

        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(NetworkStateManager.getInstance());

        //TODO tip: DataBinding 严格模式（详见 DataBindingActivity - - - - - ）：
        // 将 DataBinding 实例限制于 base 页面中，默认不向子类暴露，
        // 通过这样的方式，来彻底解决 视图调用的一致性问题，
        // 如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。

        // 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350 和 https://xiaozhuanlan.com/topic/2356748910
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        return super.getActivityViewModel(modelClass);
    }

    protected ViewModelProvider getAppViewModelProvider() {
        return super.getAppViewModelProvider();
    }

    @Override
    public Resources getResources() {
        if (ScreenUtils.isPortrait()) {
            return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
        } else {
            return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
        }
    }

    //如果输入法在窗口上已经显示，则隐藏，反之则显示
    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
