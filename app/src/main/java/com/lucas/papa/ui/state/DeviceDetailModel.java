package com.lucas.papa.ui.state;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lucas.papa.ui.adapter.multi.MultiEntity;

import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/28 16:39
 */
public class DeviceDetailModel extends ViewModel {

    public final MutableLiveData<List<MultiEntity>> list = new MutableLiveData<>();

    public final ObservableField<String> deviceName = new ObservableField<>();
    public final ObservableField<String> deviceAddress = new ObservableField<>();
}
