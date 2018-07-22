package com.joaoibarra.yat.feature.projects;

import com.joaoibarra.yat.feature.api.ApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {
    private final ProjectContract.View projectView;

    public ProjectModule(ProjectContract.View projectView) {
        this.projectView = projectView;
    }

    @Provides
    @ProjectScope
    ProjectListPresenter provideProjectListPresenter(ApiService apiService) {
        return new ProjectListPresenter(projectView, apiService);
    }
}
