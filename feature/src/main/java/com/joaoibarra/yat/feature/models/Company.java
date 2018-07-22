package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable{
    private String name;

    @SerializedName("is-owner")
    private String isOwner;

    private String id;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.isOwner);
        dest.writeString(this.id);
    }

    public Company() {
    }

    protected Company(Parcel in) {
        this.name = in.readString();
        this.isOwner = in.readString();
        this.id = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel source) {
            return new Company(source);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
}
