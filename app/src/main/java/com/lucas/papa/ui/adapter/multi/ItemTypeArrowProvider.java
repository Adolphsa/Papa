package com.lucas.papa.ui.adapter.multi;

import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lucas.papa.R;
import com.lucas.papa.databinding.LayoutItemTypeArrowBinding;

import org.jetbrains.annotations.NotNull;

/**
 * 带箭头的item
 * Created by lucas
 * Date: 2020/9/28 20:44
 */
public class ItemTypeArrowProvider extends BaseItemProvider<MultiEntity> {

    @Override
    public int getItemViewType() {
        return MultiEntity.TYPE_ARROW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_item_type_arrow;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, MultiEntity multiEntity) {
        baseViewHolder.setText(R.id.item_title, multiEntity.getItemTitle());
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, MultiEntity data, int position) {
        System.out.println("click: " + position);
    }
}
