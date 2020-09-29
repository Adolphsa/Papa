package com.lucas.papa.ui.location;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.lucas.architecture.ui.page.BaseFragment;
import com.lucas.papa.BR;
import com.lucas.papa.R;
import com.lucas.papa.ui.state.LocationViewModel;

/**
 * Created by lucas
 * Date: 2020/9/25 17:32
 * 定位
 */
public class LocationFragment extends BaseFragment {

    private LocationViewModel mLocationViewModel;

    @Override
    protected void initViewModel() {
        mLocationViewModel = getFragmentViewModel(LocationViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_location, BR.vm, mLocationViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy{

    }
}
