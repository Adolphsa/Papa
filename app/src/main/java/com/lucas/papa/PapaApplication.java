package com.lucas.papa;

import com.kunminx.architecture.BaseApplication;
import com.lucas.architecture.utils.Utils;

/**
 * Created by lucas
 * Date: 2020/9/25 14:53
 */
public class PapaApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
