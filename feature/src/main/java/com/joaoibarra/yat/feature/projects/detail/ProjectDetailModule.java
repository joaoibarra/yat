package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.projects.ProjectScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectDetailModule {
    private final ProjectDetailContract.TaskView projectDetailTaskView;

    public ProjectDetailModule(ProjectDetailContract.TaskView projectDetailTaskView) {
        this.projectDetailTaskView = projectDetailTaskView;
    }

    @Provides
    @ProjectScope
    TaskListPresenter provideTaskListPresenter(ApiService apiService) {
        return new TaskListPresenter(projectDetailTaskView, apiService);
    }
}