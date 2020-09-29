package com.lucas.papa.domain.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lucas.architecture.data.repository.DataResult;
import com.lucas.architecture.domain.request.BaseRequest;
import com.lucas.papa.data.bean.DeviceItemInfo;
import com.lucas.papa.data.repository.DataRepository;

import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/26 17:32
 */
public class DeviceListRequest extends BaseRequest {

    private MutableLiveData<List<DeviceItemInfo>> mDeviceListLiveData;

    //TODO tip 向 ui 层提供的 request LiveData，使用抽象的 LiveData 而不是 MutableLiveData
    // 如此是为了来自数据层的数据，在 ui 层中只读，以避免团队新手不可预期的误用

    public LiveData<List<DeviceItemInfo>> getLibraryLiveData() {
        if (mDeviceListLiveData == null) {
            mDeviceListLiveData = new MutableLiveData<>();
        }
        return mDeviceListLiveData;
    }

    public void requestDeviceList() {
        DataRepository.getInstance().getDeviceList(new DataResult<>((deviceItemInfoList, netState) -> {
            mDeviceListLiveData.setValue(deviceItemInfoList);
        }));
    }
}
