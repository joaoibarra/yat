package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.List;

public interface ProjectDetailContract {
    interface View {
        void initView();

        void onError(Throwable throwable);

        void populateData(List<ToDoItem> toDoItemList);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void init();

        void getProject(String id);

        void fetchTasks(String projectId);
    }
}