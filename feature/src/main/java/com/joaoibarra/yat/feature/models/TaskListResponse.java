package com.joaoibarra.yat.feature.models;

import com.google.gson.annotations.SerializedName;

public class TaskListResponse {
    @SerializedName("STATUS")
    private String status;

    @SerializedName("todo-items")
    private ToDoItem todoItems;
}
