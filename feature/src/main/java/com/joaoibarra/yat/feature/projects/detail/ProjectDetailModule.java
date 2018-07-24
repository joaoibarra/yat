package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.projects.ProjectScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectDetailModule {
    private final ProjectDetailContract.View projectDetailView;

    public ProjectDetailModule(ProjectDetailContract.View projectDetailView) {
        this.projectDetailView = projectDetailView;
    }

    @Provides
    @ProjectScope
    ProjectDetailPresenter provideProjectDetailPresenter(ApiService apiService) {
        return new ProjectDetailPresenter(projectDetailView, apiService);
    }
}