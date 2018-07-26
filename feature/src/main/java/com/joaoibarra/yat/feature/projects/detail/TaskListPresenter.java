package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.models.TaskListResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class TaskListPresenter implements ProjectDetailContract.Presenter {

    private ProjectDetailContract.TaskView projectDetailTaskView;
    private boolean isUpdating;

    private ApiService apiService;

    public TaskListPresenter(ProjectDetailContract.TaskView projectDetailTaskView, ApiService apiService) {
        this.projectDetailTaskView = projectDetailTaskView;
        this.apiService = apiService;
    }

    @Override
    public void init() {
        projectDetailTaskView.initView();
    }

    @Override
    public void fetchTasks(String projectId) {
        isUpdating = true;
        apiService.getTasksFromProject(projectId).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> projectDetailTaskView.showLoading())
                .doOnTerminate(() -> isUpdating = false)
                .map(TaskListResponse::getTodoItems)
                .subscribe(projectDetailTaskView::populateData, projectDetailTaskView::onError);
    }
}