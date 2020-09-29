package com.lucas.papa.ui.camera;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.lucas.architecture.ui.page.BaseFragment;
import com.lucas.papa.BR;
import com.lucas.papa.R;
import com.lucas.papa.ui.state.CameraViewModel;

/**
 * Created by lucas
 * Date: 2020/9/25 17:31
 * 相机
 */
public class CameraFragment extends BaseFragment {

    private CameraViewModel mCameraViewModel;

    @Override
    protected void initViewModel() {
        mCameraViewModel = getFragmentViewModel(CameraViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_camera, BR.vm, mCameraViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy{

    }
}
