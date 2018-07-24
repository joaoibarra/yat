package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Project implements Parcelable {

    private Company company;
    private boolean starred;
    private String name;

    @SerializedName("show-announcement")
    private boolean showAnnouncement;

    private String announcement;
    private String description;
    private String status;
    private boolean isProjectAdmin;

    @SerializedName("created-on")
    private String createdOn;

    private Category category;

    @SerializedName("start-page")
    private String startPage;

    private String startDate;
    private String logo;
    private boolean notifyeveryone;
    private String id;

    @SerializedName("last-changed-on")
    private String lastChangedOn;

    private String endDate;

    @SerializedName("harvest-timers-enabled")
    private boolean harvestTimersEnabled;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.company, flags);
        dest.writeByte(this.starred ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeByte(this.showAnnouncement ? (byte) 1 : (byte) 0);
        dest.writeString(this.announcement);
        dest.writeString(this.description);
        dest.writeString(this.status);
        dest.writeByte(this.isProjectAdmin ? (byte) 1 : (byte) 0);
        dest.writeString(this.createdOn);
        dest.writeParcelable(this.category, flags);
        dest.writeString(this.startPage);
        dest.writeString(this.startDate);
        dest.writeString(this.logo);
        dest.writeByte(this.notifyeveryone ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
        dest.writeString(this.lastChangedOn);
        dest.writeString(this.endDate);
        dest.writeByte(this.harvestTimersEnabled ? (byte) 1 : (byte) 0);
    }

    public Project() {
    }

    protected Project(Parcel in) {
        this.company = in.readParcelable(Company.class.getClassLoader());
        this.starred = in.readByte() != 0;
        this.name = in.readString();
        this.showAnnouncement = in.readByte() != 0;
        this.announcement = in.readString();
        this.description = in.readString();
        this.status = in.readString();
        this.isProjectAdmin = in.readByte() != 0;
        this.createdOn = in.readString();
        this.category = in.readParcelable(Category.class.getClassLoader());
        this.startPage = in.readString();
        this.startDate = in.readString();
        this.logo = in.readString();
        this.notifyeveryone = in.readByte() != 0;
        this.id = in.readString();
        this.lastChangedOn = in.readString();
        this.endDate = in.readString();
        this.harvestTimersEnabled = in.readByte() != 0;
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isProjectAdmin() {
        return isProjectAdmin;
    }

    public void setProjectAdmin(boolean projectAdmin) {
        isProjectAdmin = projectAdmin;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isNotifyeveryone() {
        return notifyeveryone;
    }

    public void setNotifyeveryone(boolean notifyeveryone) {
        this.notifyeveryone = notifyeveryone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isHarvestTimersEnabled() {
        return harvestTimersEnabled;
    }

    public void setHarvestTimersEnabled(boolean harvestTimersEnabled) {
        this.harvestTimersEnabled = harvestTimersEnabled;
    }
}
