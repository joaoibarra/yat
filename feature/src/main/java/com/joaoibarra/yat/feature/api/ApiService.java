package com.joaoibarra.yat.feature.api;


import com.joaoibarra.yat.feature.models.ProjectListResponse;
import com.joaoibarra.yat.feature.models.TaskListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("projects.json")
    Observable<ProjectListResponse> getProjectList();

    @GET("projects/{id}.json")
    Observable<ProjectListResponse> getProject(@Path("id") String projectId);

    @GET("projects/{id}/tasks.json")
    Observable<TaskListResponse> getTasksFromProject(@Path("id") String projectId);
}
