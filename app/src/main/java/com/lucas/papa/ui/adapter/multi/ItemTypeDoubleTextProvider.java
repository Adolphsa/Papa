package com.lucas.papa.ui.adapter.multi;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lucas.papa.R;

import org.jetbrains.annotations.NotNull;

/**
 * 双文本 item
 * Created by lucas
 * Date: 2020/9/28 20:44
 */
public class ItemTypeDoubleTextProvider extends BaseItemProvider<MultiEntity> {

    @Override
    public int getItemViewType() {
        return MultiEntity.TYPE_DOUBLE_TEXT;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_item_type_double_text;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, MultiEntity multiEntity) {
        baseViewHolder.setText(R.id.item_title, multiEntity.getItemTitle());
        baseViewHolder.setText(R.id.item_name, multiEntity.getName());
    }
}
