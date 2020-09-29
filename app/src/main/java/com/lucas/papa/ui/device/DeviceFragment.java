package com.lucas.papa.ui.device;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.lucas.architecture.ui.page.BaseFragment;
import com.lucas.papa.BR;
import com.lucas.papa.R;
import com.lucas.papa.ui.adapter.DeviceListAdapter;
import com.lucas.papa.ui.state.DeviceViewModel;

/**
 * Created by lucas
 * Date: 2020/9/25 17:32
 * 设备
 */
public class DeviceFragment extends BaseFragment {

    private static final String TAG = "DeviceFragment";

    private DeviceViewModel mDeviceViewModel;

    @Override
    protected void initViewModel() {
        mDeviceViewModel = getFragmentViewModel(DeviceViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_device, BR.vm, mDeviceViewModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new DeviceListAdapter(getContext()));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDeviceViewModel.deviceListRequest.getLibraryLiveData().observe(getViewLifecycleOwner(), deviceItemInfoList -> {
            mDeviceViewModel.list.setValue(deviceItemInfoList);
        });

        mDeviceViewModel.deviceListRequest.requestDeviceList();
    }

    public class ClickProxy{

        public void addDevice()
        {
            Log.i(TAG, "addDevice: ");
        }
    }
}
