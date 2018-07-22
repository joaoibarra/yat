package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProjectResponse implements Parcelable {
    @SerializedName("STATUS")
    private String status;

    private Project project;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeParcelable(this.project, flags);
    }

    public ProjectResponse() {
    }

    protected ProjectResponse(Parcel in) {
        this.status = in.readString();
        this.project = in.readParcelable(Project.class.getClassLoader());
    }

    public static final Creator<ProjectResponse> CREATOR = new Creator<ProjectResponse>() {
        @Override
        public ProjectResponse createFromParcel(Parcel source) {
            return new ProjectResponse(source);
        }

        @Override
        public ProjectResponse[] newArray(int size) {
            return new ProjectResponse[size];
        }
    };
}
