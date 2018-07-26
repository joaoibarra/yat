package com.joaoibarra.yat.feature.mock.api;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.models.ProjectListResponse;
import com.joaoibarra.yat.feature.models.TaskListResponse;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Path;

public class MockApiService implements ApiService {
    @Override
    public Observable<ProjectListResponse> getProjectList() {
        ProjectListResponse response = new ProjectListResponse();
        response.setProjects(new ArrayList<>());
        return Observable.just(response);
    }

    @Override
    public Observable<TaskListResponse> getTasksFromProject(@Path("id") String projectId) {
        TaskListResponse response = new TaskListResponse();
        response.setTodoItems(new ArrayList<>());
        return Observable.just(response);
    }
}
