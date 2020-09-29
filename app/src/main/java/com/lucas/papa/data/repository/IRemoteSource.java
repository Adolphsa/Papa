package com.lucas.papa.data.repository;


import com.lucas.architecture.data.repository.DataResult;
import com.lucas.papa.data.bean.DeviceItemInfo;

import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/26 16:41
 */
public interface IRemoteSource {

    void getDeviceList(DataResult<List<DeviceItemInfo>> result);
}
