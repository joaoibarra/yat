package com.joaoibarra.yat.feature.base;

import com.joaoibarra.yat.feature.AppModule;
import com.joaoibarra.yat.feature.api.ApiModule;
import com.joaoibarra.yat.feature.projects.ProjectComponent;
import com.joaoibarra.yat.feature.projects.ProjectModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(BaseApplication baseApplication);

    ProjectComponent newProjectComponent(ProjectModule projectModule);
}
