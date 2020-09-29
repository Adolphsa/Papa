package com.lucas.architecture.ui.page;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.kunminx.architecture.ui.page.DataBindingFragment;

/**
 * Created by lucas
 * Date: 2020/9/25 14:44
 */
public abstract class BaseFragment extends DataBindingFragment {

    //TODO tip: DataBinding 严格模式（详见 DataBindingFragment - - - - - ）：
    // 将 DataBinding 实例限制于 base 页面中，默认不向子类暴露，
    // 通过这样的方式，来彻底解决 视图调用的一致性问题，
    // 如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。

    // 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350 和 https://xiaozhuanlan.com/topic/2356748910

    protected <T extends ViewModel> T getFragmentViewModel(@NonNull Class<T> modelClass) {
        return super.getFragmentViewModel(modelClass);
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        return super.getActivityViewModel(modelClass);
    }

    protected ViewModelProvider getAppViewModelProvider() {
        return super.getAppViewModelProvider();
    }

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }

    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
