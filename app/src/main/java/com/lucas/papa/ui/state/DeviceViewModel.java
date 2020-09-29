package com.lucas.papa.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.lucas.architecture.data.repository.DataResult;
import com.lucas.papa.data.bean.DeviceItemInfo;
import com.lucas.papa.data.repository.DataRepository;
import com.lucas.papa.domain.request.DeviceListRequest;

import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/25 17:35
 */
public class DeviceViewModel extends ViewModel {

    public final MutableLiveData<List<DeviceItemInfo>> list = new MutableLiveData<>();

    public final DeviceListRequest deviceListRequest = new DeviceListRequest();
}
