package com.lucas.papa.ui.adapter.multi;

import android.view.View;
import android.widget.CompoundButton;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.lucas.papa.R;

import org.jetbrains.annotations.NotNull;

/**
 * 带开关的item
 * Created by lucas
 * Date: 2020/9/28 20:44
 */
public class ItemTypeSwitchProvider extends BaseItemProvider<MultiEntity> {

    @Override
    public int getItemViewType() {
        return MultiEntity.TYPE_SWITCH;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_item_type_switch;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, MultiEntity multiEntity) {
        baseViewHolder.setText(R.id.item_title, multiEntity.getItemTitle());

        SwitchMaterial switchMaterial = baseViewHolder.itemView.findViewById(R.id.item_switch);
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("switch status: " + isChecked);
            }
        });
    }

}
