package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProjectListResponse implements Parcelable {
    @SerializedName("STATUS")
    private String status;

    private List<Project> projects;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        //dest.writeList(this.projects);
    }

    public ProjectListResponse() {
    }

    protected ProjectListResponse(Parcel in) {
        this.status = in.readString();
        this.projects = new ArrayList<Project>();
        //in.readList(this.projects, Project.class.getClassLoader());
    }

    public static final Creator<ProjectListResponse> CREATOR = new Creator<ProjectListResponse>() {
        @Override
        public ProjectListResponse createFromParcel(Parcel source) {
            return new ProjectListResponse(source);
        }

        @Override
        public ProjectListResponse[] newArray(int size) {
            return new ProjectListResponse[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
