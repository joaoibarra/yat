package com.joaoibarra.yat.feature.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem implements Parcelable{
    private String id;
    private boolean canComplete;

    @SerializedName("comments-count")
    private String commentsCount;

    private String description;

    @SerializedName("has-reminders")
    private boolean hasReminders;

    @SerializedName("has-unread-comments")
    private boolean hasUnreadComments;

    @SerializedName("private")
    private String isPrivate;

    private String content;

    private String order;

    @SerializedName("project-id")
    private String projectId;

    @SerializedName("project-name")
    private String projectName;

    @SerializedName("todo-list-id")
    private String todoListId;

    @SerializedName("todo-list-name")
    private String todoListName;

    @SerializedName("tasklist-private")
    private boolean tasklistPrivate;

    @SerializedName("tasklist-isTemplate")
    private boolean tasklistIsTemplate;

    private String status;

    @SerializedName("company-name")
    private String companyName;

    @SerializedName("company-id")
    private String companyId;

    @SerializedName("creator-id")
    private String creatorId;

    @SerializedName("creator-firstname")
    private String creatorFirstname;

    @SerializedName("creator-lastname")
    private String creatorLastname;

    private boolean completed;

    @SerializedName("start-date")
    private String startDate;

    @SerializedName("due-date-base")
    private String dueDateBase;

    @SerializedName("due-date")
    private String dueDate;

    @SerializedName("created-on")
    private String createdOn;

    @SerializedName("last-changed-on")
    private String lastChangedOn;

    private String position;

    @SerializedName("estimated-minutes")
    private String estimatedMinutes;

    private String priority;

    private String progress;

    @SerializedName("harvest-enabled")
    private boolean harvestEnabled;

    private String parentTaskId;

    private String lockdownId;

    @SerializedName("tasklist-lockdownId")
    private String tasklistLockdownId;

    @SerializedName("has-dependencies")
    private String hasDependencies;

    @SerializedName("has-predecessors")
    private String hasPredecessors;

    private boolean hasTickets;

    private String timeIsLogged;

    @SerializedName("attachments-count")
    private String attachmentsCount;

    private boolean canEdit;

    private boolean viewEstimatedTime;

    @SerializedName("creator-avatar-url")
    private String creatorAvatarUrl;

    private boolean canLogTime;

    private boolean userFollowingComments;

    private boolean userFollowingChanges;

    private String DLM;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeByte(this.canComplete ? (byte) 1 : (byte) 0);
        dest.writeString(this.commentsCount);
        dest.writeString(this.description);
        dest.writeByte(this.hasReminders ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasUnreadComments ? (byte) 1 : (byte) 0);
        dest.writeString(this.isPrivate);
        dest.writeString(this.content);
        dest.writeString(this.order);
        dest.writeString(this.projectId);
        dest.writeString(this.projectName);
        dest.writeString(this.todoListId);
        dest.writeString(this.todoListName);
        dest.writeByte(this.tasklistPrivate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.tasklistIsTemplate ? (byte) 1 : (byte) 0);
        dest.writeString(this.status);
        dest.writeString(this.companyName);
        dest.writeString(this.companyId);
        dest.writeString(this.creatorId);
        dest.writeString(this.creatorFirstname);
        dest.writeString(this.creatorLastname);
        dest.writeByte(this.completed ? (byte) 1 : (byte) 0);
        dest.writeString(this.startDate);
        dest.writeString(this.dueDateBase);
        dest.writeString(this.dueDate);
        dest.writeString(this.createdOn);
        dest.writeString(this.lastChangedOn);
        dest.writeString(this.position);
        dest.writeString(this.estimatedMinutes);
        dest.writeString(this.priority);
        dest.writeString(this.progress);
        dest.writeByte(this.harvestEnabled ? (byte) 1 : (byte) 0);
        dest.writeString(this.parentTaskId);
        dest.writeString(this.lockdownId);
        dest.writeString(this.tasklistLockdownId);
        dest.writeString(this.hasDependencies);
        dest.writeString(this.hasPredecessors);
        dest.writeByte(this.hasTickets ? (byte) 1 : (byte) 0);
        dest.writeString(this.timeIsLogged);
        dest.writeString(this.attachmentsCount);
        dest.writeByte(this.canEdit ? (byte) 1 : (byte) 0);
        dest.writeByte(this.viewEstimatedTime ? (byte) 1 : (byte) 0);
        dest.writeString(this.creatorAvatarUrl);
        dest.writeByte(this.canLogTime ? (byte) 1 : (byte) 0);
        dest.writeByte(this.userFollowingComments ? (byte) 1 : (byte) 0);
        dest.writeByte(this.userFollowingChanges ? (byte) 1 : (byte) 0);
        dest.writeString(this.DLM);
    }

    public ToDoItem() {
    }

    protected ToDoItem(Parcel in) {
        this.id = in.readString();
        this.canComplete = in.readByte() != 0;
        this.commentsCount = in.readString();
        this.description = in.readString();
        this.hasReminders = in.readByte() != 0;
        this.hasUnreadComments = in.readByte() != 0;
        this.isPrivate = in.readString();
        this.content = in.readString();
        this.order = in.readString();
        this.projectId = in.readString();
        this.projectName = in.readString();
        this.todoListId = in.readString();
        this.todoListName = in.readString();
        this.tasklistPrivate = in.readByte() != 0;
        this.tasklistIsTemplate = in.readByte() != 0;
        this.status = in.readString();
        this.companyName = in.readString();
        this.companyId = in.readString();
        this.creatorId = in.readString();
        this.creatorFirstname = in.readString();
        this.creatorLastname = in.readString();
        this.completed = in.readByte() != 0;
        this.startDate = in.readString();
        this.dueDateBase = in.readString();
        this.dueDate = in.readString();
        this.createdOn = in.readString();
        this.lastChangedOn = in.readString();
        this.position = in.readString();
        this.estimatedMinutes = in.readString();
        this.priority = in.readString();
        this.progress = in.readString();
        this.harvestEnabled = in.readByte() != 0;
        this.parentTaskId = in.readString();
        this.lockdownId = in.readString();
        this.tasklistLockdownId = in.readString();
        this.hasDependencies = in.readString();
        this.hasPredecessors = in.readString();
        this.hasTickets = in.readByte() != 0;
        this.timeIsLogged = in.readString();
        this.attachmentsCount = in.readString();
        this.canEdit = in.readByte() != 0;
        this.viewEstimatedTime = in.readByte() != 0;
        this.creatorAvatarUrl = in.readString();
        this.canLogTime = in.readByte() != 0;
        this.userFollowingComments = in.readByte() != 0;
        this.userFollowingChanges = in.readByte() != 0;
        this.DLM = in.readString();
    }

    public static final Creator<ToDoItem> CREATOR = new Creator<ToDoItem>() {
        @Override
        public ToDoItem createFromParcel(Parcel source) {
            return new ToDoItem(source);
        }

        @Override
        public ToDoItem[] newArray(int size) {
            return new ToDoItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public boolean isCanComplete() {
        return canComplete;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHasReminders() {
        return hasReminders;
    }

    public boolean isHasUnreadComments() {
        return hasUnreadComments;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public String getContent() {
        return content;
    }

    public String getOrder() {
        return order;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getTodoListId() {
        return todoListId;
    }

    public String getTodoListName() {
        return todoListName;
    }

    public boolean isTasklistPrivate() {
        return tasklistPrivate;
    }

    public boolean isTasklistIsTemplate() {
        return tasklistIsTemplate;
    }

    public String getStatus() {
        return status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getCreatorFirstname() {
        return creatorFirstname;
    }

    public String getCreatorLastname() {
        return creatorLastname;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDueDateBase() {
        return dueDateBase;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getFormatDueDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormatToString = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = dateFormat.parse(dueDate);
            return dateFormatToString.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
            return "No Due Date";
        }
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public String getPosition() {
        return position;
    }

    public String getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public String getPriority() {
        return priority;
    }

    public String getProgress() {
        return progress;
    }

    public boolean isHarvestEnabled() {
        return harvestEnabled;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public String getLockdownId() {
        return lockdownId;
    }

    public String getTasklistLockdownId() {
        return tasklistLockdownId;
    }

    public String getHasDependencies() {
        return hasDependencies;
    }

    public String getHasPredecessors() {
        return hasPredecessors;
    }

    public boolean isHasTickets() {
        return hasTickets;
    }

    public String getTimeIsLogged() {
        return timeIsLogged;
    }

    public String getAttachmentsCount() {
        return attachmentsCount;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public boolean isViewEstimatedTime() {
        return viewEstimatedTime;
    }

    public String getCreatorAvatarUrl() {
        return creatorAvatarUrl;
    }

    public boolean isCanLogTime() {
        return canLogTime;
    }

    public boolean isUserFollowingComments() {
        return userFollowingComments;
    }

    public boolean isUserFollowingChanges() {
        return userFollowingChanges;
    }

    public String getDLM() {
        return DLM;
    }
}
