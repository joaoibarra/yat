package com.joaoibarra.yat.feature.tasks;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.projects.ProjectScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskModule {
    private final TaskContract.View taskView;

    public TaskModule(TaskContract.View taskView) {
        this.taskView = taskView;
    }

    @Provides
    @ProjectScope
    TaskPresenter provideTaskPresenter(ApiService apiService) {
        return new TaskPresenter(taskView, apiService);
    }
}
