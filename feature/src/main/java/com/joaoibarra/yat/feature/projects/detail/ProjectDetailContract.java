package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.List;

public interface ProjectDetailContract {
    interface TaskView {
        void initView();

        void onError(Throwable throwable);

        void populateData(List<ToDoItem> toDoItemList);

        void onToDoItemSelected(ToDoItem toDoItem);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void init();

        void fetchTasks(String projectId);
    }
}