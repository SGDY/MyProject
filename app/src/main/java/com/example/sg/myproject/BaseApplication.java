package com.example.sg.myproject;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by sg on 2015/3/18.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * chromeµ÷ÊÔApp
         */
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
