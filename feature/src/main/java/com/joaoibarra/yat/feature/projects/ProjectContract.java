package com.joaoibarra.yat.feature.projects;

import com.joaoibarra.yat.feature.models.Project;

import java.util.List;

public interface ProjectContract {

    interface View {
        void initView();

        void populateData(List<Project> projectList);

        void onProjectItemSelected(Project project);

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void init();

        void fetchProjects();

        boolean shouldUpdate();

        void showLoading();

        void hideLoading();
    }
}
