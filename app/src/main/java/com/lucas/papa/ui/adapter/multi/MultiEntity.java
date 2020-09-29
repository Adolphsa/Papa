package com.lucas.papa.ui.adapter.multi;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by lucas
 * Date: 2020/9/29 10:06
 */
public class MultiEntity {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_DOUBLE_TEXT = 2;
    public static final int TYPE_ARROW = 3;
    public static final int TYPE_SWITCH = 4;

    private String itemTitle;
    private String name;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
