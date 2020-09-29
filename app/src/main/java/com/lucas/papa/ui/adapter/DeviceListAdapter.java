package com.lucas.papa.ui.adapter;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;
import com.lucas.papa.R;
import com.lucas.papa.data.bean.DeviceItemInfo;
import com.lucas.papa.data.config.Configs;
import com.lucas.papa.databinding.LayoutDeviceListItemBinding;
import com.lucas.papa.ui.device.DeviceDetailActivity;

/**
 * Created by lucas
 * Date: 2020/9/28 14:59
 */
public class DeviceListAdapter extends SimpleDataBindingAdapter<DeviceItemInfo, LayoutDeviceListItemBinding> {

    public DeviceListAdapter(Context context)
    {
        super(context, R.layout.layout_device_list_item, DiffUtils.getInstance().getDeviceItemInfoItemCallback());
        setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent(context, DeviceDetailActivity.class);
            intent.putExtra(Configs.BEAN_DEVICE_ITEM_INFO, item);
            context.startActivity(intent);
        }));
    }


    @Override
    protected void onBindItem(LayoutDeviceListItemBinding binding, DeviceItemInfo item, RecyclerView.ViewHolder holder) {
        binding.setDevice(item);
    }


}
