package com.joaoibarra.yat.feature.base;

import com.joaoibarra.yat.feature.api.ApiModule;
import com.joaoibarra.yat.feature.projects.ProjectComponent;
import com.joaoibarra.yat.feature.projects.ProjectModule;
import com.joaoibarra.yat.feature.projects.detail.ProjectDetailComponent;
import com.joaoibarra.yat.feature.projects.detail.ProjectDetailModule;
import com.joaoibarra.yat.feature.tasks.TaskComponent;
import com.joaoibarra.yat.feature.tasks.TaskModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(BaseApplication baseApplication);

    ProjectComponent newProjectComponent(ProjectModule projectModule);

    ProjectDetailComponent newProjectDetailComponent(ProjectDetailModule projectDetailModule);

    TaskComponent newTaskComponent(TaskModule taskModule);
}
