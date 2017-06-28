package com.zhy.autolayout.config;

import android.content.Context;

import com.zhy.autolayout.utils.ScreenUtils;

/**
 * Created by zhy on 15/11/18.
 */
public class AutoLayoutConfig
{

    private static AutoLayoutConfig sInstance = new AutoLayoutConfig();


    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static final String KEY_DESIGN_HEIGHT = "design_height";

    private int mScreenWidth;
    private int mScreenHeight;

    private int mDesignWidth;
    private int mDesignHeight;
    public static boolean HasInitConfig;

    private boolean useDeviceSize;


    private AutoLayoutConfig() {}

    public void checkParams() {
        if (mDesignHeight <= 0 || mDesignWidth <= 0) {
            throw new RuntimeException(
                    "you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.");
        }
    }

    public AutoLayoutConfig useDeviceSize() {
        useDeviceSize = true;
        return this;
    }

    public AutoLayoutConfig useAvailableSize() {
        useDeviceSize = false;
        return this;
    }


    public static AutoLayoutConfig getInstance()
    {
        return sInstance;
    }


    public int getScreenWidth() {
        return mScreenWidth;
    }

    public int getScreenHeight() {
        return mScreenHeight;
    }

    public int getDesignWidth() {
        return mDesignWidth;
    }

    public int getDesignHeight()
    {
        return mDesignHeight;
    }


    public void initWithDesignSize(Context context, int DesignWidth, int DesignHeight) {
        getMetaData(DesignWidth, DesignHeight);
        int[] screenSize = ScreenUtils.getScreenSize(context, useDeviceSize);
        mScreenWidth = screenSize[0];
        mScreenHeight = screenSize[1];
    }

    private void getMetaData(int DesignWidth, int DesignHeight) {
        if (!HasInitConfig) {
            if (DesignWidth == 0 || DesignHeight == 0) {
                throw new RuntimeException("invalid design size");
            }
            mDesignWidth = DesignWidth;
            mDesignHeight = DesignHeight;
//            Log.e("width---height", mDesignWidth + "   " + mDesignHeight, null);
            HasInitConfig = true;
        }
    }
}
