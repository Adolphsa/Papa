package com.lucas.papa.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.lucas.papa.data.bean.DeviceItemInfo;

/**
 * Created by lucas
 * Date: 2020/9/28 15:05
 */
public class DiffUtils {

    private DiffUtil.ItemCallback<DeviceItemInfo> mDeviceItemInfoItemCallback;

    private DiffUtils() {
    }

    private static DiffUtils sDiffUtils = new DiffUtils();

    public static DiffUtils getInstance() {
        return sDiffUtils;
    }

    public DiffUtil.ItemCallback<DeviceItemInfo> getDeviceItemInfoItemCallback() {
        if (mDeviceItemInfoItemCallback == null) {
            mDeviceItemInfoItemCallback = new DiffUtil.ItemCallback<DeviceItemInfo>() {
                @Override
                public boolean areItemsTheSame(@NonNull DeviceItemInfo oldItem, @NonNull DeviceItemInfo newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull DeviceItemInfo oldItem, @NonNull DeviceItemInfo newItem) {
                    return oldItem.getDeviceName().equals(newItem.getDeviceName());
                }
            };
        }
        return mDeviceItemInfoItemCallback;
    }

}
