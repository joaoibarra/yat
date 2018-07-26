package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.models.TaskListResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ProjectDetailPresenter implements ProjectDetailContract.Presenter {

    private ProjectDetailContract.View projectDetailView;
    private boolean isUpdating;

    private ApiService apiService;

    public ProjectDetailPresenter(ProjectDetailContract.View projectDetailView, ApiService apiService) {
        this.projectDetailView = projectDetailView;
        this.apiService = apiService;
    }

    @Override
    public void init() {
        projectDetailView.initView();
    }

    @Override
    public void getProject(String projectId) {
        isUpdating = true;
        apiService.getTasksFromProject(projectId).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> projectDetailView.showLoading())
                .doOnTerminate(() -> isUpdating = false)
                .map(TaskListResponse::getTodoItems)
                .subscribe(projectDetailView::populateData, projectDetailView::onError);
    }

    @Override
    public void fetchTasks(String projectId) {
        isUpdating = true;
        apiService.getTasksFromProject(projectId).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> projectDetailView.showLoading())
                .doOnTerminate(() -> isUpdating = false)
                .map(TaskListResponse::getTodoItems)
                .subscribe(projectDetailView::populateData, projectDetailView::onError);
    }
}