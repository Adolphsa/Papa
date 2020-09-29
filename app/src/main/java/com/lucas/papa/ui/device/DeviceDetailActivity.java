package com.lucas.papa.ui.device;

import android.os.Bundle;
import android.os.UserManager;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.lucas.architecture.ui.page.BaseActivity;
import com.lucas.papa.BR;
import com.lucas.papa.R;
import com.lucas.papa.data.bean.DeviceItemInfo;
import com.lucas.papa.data.config.Configs;
import com.lucas.papa.databinding.ActivityDeviceDetailBinding;
import com.lucas.papa.ui.adapter.MultipleItemQuickAdapter;
import com.lucas.papa.ui.adapter.multi.MultiEntity;
import com.lucas.papa.ui.state.DeviceDetailModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备详情
 * Created by lucas
 * Date: 2020/9/28 16:38
 */
public class DeviceDetailActivity extends BaseActivity {

    private DeviceDetailModel mDeviceDetailModel;
    private MultipleItemQuickAdapter mAdapter;
    private ActivityDeviceDetailBinding mDetailBinding;

    @Override
    protected void initViewModel() {
        mDeviceDetailModel = getActivityViewModel(DeviceDetailModel.class);
        mAdapter = new MultipleItemQuickAdapter();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_device_detail, BR.vm, mDeviceDetailModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, mAdapter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceItemInfo deviceItemInfo = getIntent().getParcelableExtra(Configs.BEAN_DEVICE_ITEM_INFO);
        if (deviceItemInfo != null)
        {
            mDeviceDetailModel.deviceName.set(deviceItemInfo.getDeviceName());
            mDeviceDetailModel.deviceAddress.set(deviceItemInfo.getAddress());
        }


//        mDetailBinding = (ActivityDeviceDetailBinding) getBinding();
//        mDetailBinding.deviceStatusInfoList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mAdapter.setList(getMultiItemData());
    }

    public List<MultiEntity> getMultiItemData()
    {
        List<MultiEntity> list = new ArrayList<>();
        MultiEntity multiEntity0 = new MultiEntity();
        multiEntity0.setItemTitle("名称");
        multiEntity0.setName("钥匙");
        list.add(multiEntity0);

        MultiEntity multiEntity1 = new MultiEntity();
        multiEntity1.setItemTitle("蓝牙断开报警");
        list.add(multiEntity1);

        MultiEntity multiEntity2 = new MultiEntity();
        multiEntity2.setItemTitle("铃声选择");
        list.add(multiEntity2);

        MultiEntity multiEntity3 = new MultiEntity();
        multiEntity3.setItemTitle("寻物模式");
        list.add(multiEntity3);

        MultiEntity multiEntity4 = new MultiEntity();
        multiEntity4.setItemTitle("双向防丢");
        list.add(multiEntity4);

        MultiEntity multiEntity5 = new MultiEntity();
        multiEntity5.setItemTitle("遗失记录");
        list.add(multiEntity5);

        MultiEntity multiEntity6 = new MultiEntity();
        multiEntity6.setItemTitle("使用说明");
        list.add(multiEntity6);

        return list;
    }

    public class ClickProxy {

        public void back(){
            finish();
        }

    }
}
