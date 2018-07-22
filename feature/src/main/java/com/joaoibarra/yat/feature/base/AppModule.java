package com.joaoibarra.yat.feature;

import com.joaoibarra.yat.feature.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BaseApplication providesApplication () {
        return application;
    }
}
