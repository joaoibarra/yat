package com.joaoibarra.yat.feature.projects.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private Context context;
    private List<ToDoItem> toDoItemList;
    private LayoutInflater layoutInflater;
    private ProjectDetailContract.View projectDetailView;

    public TaskListAdapter(Context context, ProjectDetailContract.View projectDetailView) {
        this.context = context;
        toDoItemList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.projectDetailView = projectDetailView;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskViewHolder(layoutInflater.inflate(R.layout.view_project_item, parent,
                false));
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bindViews(toDoItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return toDoItemList.size();
    }

    public void addAll(List<ToDoItem> toDoItemList) {
        clear();
        this.toDoItemList.addAll(toDoItemList);
        this.notifyDataSetChanged();
    }

    public void clear() {
        if (toDoItemList != null) {
            toDoItemList.clear();
        }
    }

    public List<ToDoItem> getToDoItemList() {
        return toDoItemList;
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.iv_project_logo)
        ImageView ivProjectLogo;

        @BindView(R2.id.tv_project_name)
        TextView tvProjectName;

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("CheckResult")
        void bindViews(ToDoItem toDoItem) {
            tvProjectName.setText(toDoItem.getTodoListName());
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.fitCenter();
            Glide.with(context)
                    .asDrawable()
                    .apply(requestOptions)
                    .load(toDoItem.getCreatorAvatarUrl())
                    .into(ivProjectLogo);        }
    }
}
