package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskListResponse implements Parcelable{
    @SerializedName("STATUS")
    private String status;

    @SerializedName("todo-items")
    private List<ToDoItem> todoItems;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeTypedList(this.todoItems);
    }

    public TaskListResponse() {
    }

    protected TaskListResponse(Parcel in) {
        this.status = in.readString();
        this.todoItems = in.createTypedArrayList(ToDoItem.CREATOR);
    }

    public static final Creator<TaskListResponse> CREATOR = new Creator<TaskListResponse>() {
        @Override
        public TaskListResponse createFromParcel(Parcel source) {
            return new TaskListResponse(source);
        }

        @Override
        public TaskListResponse[] newArray(int size) {
            return new TaskListResponse[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public List<ToDoItem> getTodoItems() {
        return todoItems;
    }
}