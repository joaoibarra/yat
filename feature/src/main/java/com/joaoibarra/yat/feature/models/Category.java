package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private String name;
    private String id;
    private String color;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
        dest.writeString(this.color);
    }

    public Category() {
    }

    protected Category(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.color = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
