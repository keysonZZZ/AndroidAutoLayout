package com.zhy.sample;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConfig;

/**
 * Created by zhy on 15/12/23.
 */
public class UseDeviceSizeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            AutoLayoutConfig.getInstance().useAvailableSize().initWithDesignSize(this, 1080, 1960);
        } else {
            AutoLayoutConfig.getInstance().useAvailableSize().initWithDesignSize(this, 540, 980);
        }
    }
}
