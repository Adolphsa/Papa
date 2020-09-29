package com.lucas.papa.ui.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.lucas.papa.ui.adapter.multi.ItemTypeArrowProvider;
import com.lucas.papa.ui.adapter.multi.ItemTypeDoubleTextProvider;
import com.lucas.papa.ui.adapter.multi.ItemTypeSwitchProvider;
import com.lucas.papa.ui.adapter.multi.ItemTypeTextProvider;
import com.lucas.papa.ui.adapter.multi.MultiEntity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by lucas
 * Date: 2020/9/28 20:42
 */
public class MultipleItemQuickAdapter extends BaseProviderMultiAdapter<MultiEntity> {


    public MultipleItemQuickAdapter()
    {
        super();
        addItemProvider(new ItemTypeDoubleTextProvider());
        addItemProvider(new ItemTypeSwitchProvider());
        addItemProvider(new ItemTypeArrowProvider());
        addItemProvider(new ItemTypeTextProvider());
    }


    @Override
    protected int getItemType(@NotNull List<? extends MultiEntity> list, int i) {

        switch (i){
            case 0:
                return MultiEntity.TYPE_DOUBLE_TEXT;
            case 1:
            case 3:
            case 4:
                return MultiEntity.TYPE_SWITCH;
            case 2:
                return MultiEntity.TYPE_ARROW;
            case 5:
            case 6:
                return MultiEntity.TYPE_TEXT;
            default:
                break;
        }
        return 0;
    }
}
