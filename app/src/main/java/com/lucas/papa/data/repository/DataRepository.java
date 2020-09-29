package com.lucas.papa.data.repository;

import android.app.admin.DeviceAdminInfo;
import android.content.res.Resources;

import androidx.lifecycle.MutableLiveData;

import com.lucas.architecture.data.repository.DataResult;
import com.lucas.architecture.domain.manager.NetState;
import com.lucas.papa.R;
import com.lucas.papa.data.bean.DeviceItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/26 16:42
 */
public class DataRepository implements ILocalSource, IRemoteSource{

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();
    private MutableLiveData<String> responseCodeLiveData;

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    @Override
    public void getDeviceList(DataResult<List<DeviceItemInfo>> result) {

        List<DeviceItemInfo> list = new ArrayList<DeviceItemInfo>();

        DeviceItemInfo deviceItemInfo1 = new DeviceItemInfo();
        deviceItemInfo1.setDeviceName("哈哈");
        deviceItemInfo1.setHeaderImg(R.drawable.ic_baseline_bluetooth_audio_24);
        deviceItemInfo1.setAddress("深圳市宝安区西乡大道");
        deviceItemInfo1.setSignalImg(R.drawable.icon_signal);
        list.add(deviceItemInfo1);

        DeviceItemInfo deviceItemInfo2 = new DeviceItemInfo();
        deviceItemInfo2.setDeviceName("呵呵");
        deviceItemInfo2.setHeaderImg(R.drawable.ic_baseline_adb_24);
        deviceItemInfo2.setAddress("深圳市南山区滨海大道");
        deviceItemInfo2.setSignalImg(R.drawable.icon_signal);
        list.add(deviceItemInfo2);

        result.setResult(list, new NetState());
    }
}
