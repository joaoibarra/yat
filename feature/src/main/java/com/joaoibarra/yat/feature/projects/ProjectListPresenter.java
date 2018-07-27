package com.joaoibarra.yat.feature.projects;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.models.ProjectListResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ProjectListPresenter implements ProjectContract.Presenter {

    private ProjectContract.View projectView;
    private boolean isUpdating;

    private ApiService apiService;

    public ProjectListPresenter(ProjectContract.View projectView, ApiService apiService) {
        super();
        this.projectView = projectView;
        this.apiService = apiService;
    }

    @Override
    public void init() {
        projectView.initView();
    }

    @Override
    public void fetchProjects() {
        isUpdating = true;
        apiService.getProjectList().observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> projectView.showLoading())
                .doOnTerminate(() -> isUpdating = false)
                .map(ProjectListResponse::getProjects)
                .subscribe(projectView::populateData, projectView::onError);
    }

    @Override
    public boolean shouldUpdate() {
        return !isUpdating;
    }


    @Override
    public void showLoading() {
        projectView.showLoading();
    }

    @Override
    public void hideLoading() {
        projectView.hideLoading();
    }
}
