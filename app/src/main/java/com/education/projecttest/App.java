package com.education.projecttest;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.litesuits.orm.LiteOrm;

/**
 * Created by zhonghang on 2016/10/19.
 */

public class App extends Application {
    public static LiteOrm liteOrm;

    @Override
    public void onCreate() {
        super.onCreate();
        liteOrm = LiteOrm.newSingleInstance(this, "douyu.db");
        Fresco.initialize(this);
    }
}
