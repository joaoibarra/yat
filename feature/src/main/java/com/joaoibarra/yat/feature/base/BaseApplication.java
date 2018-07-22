package com.joaoibarra.yat.feature.base;

import android.app.Application;

import com.joaoibarra.yat.feature.AppModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}