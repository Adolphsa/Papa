package com.lucas.papa.ui.setting;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.lucas.architecture.ui.page.BaseFragment;
import com.lucas.papa.BR;
import com.lucas.papa.R;
import com.lucas.papa.ui.state.SettingViewModel;

/**
 * Created by lucas
 * Date: 2020/9/25 17:32
 * 设置
 */
public class SettingFragment extends BaseFragment {

    private SettingViewModel mSettingViewModel;

    @Override
    protected void initViewModel() {
        mSettingViewModel = getFragmentViewModel(SettingViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_setting, BR.vm, mSettingViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy{

    }
}
