package com.joaoibarra.yat.feature.projects;

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
import com.joaoibarra.yat.feature.models.Project;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder> {
    private Context context;
    private List<Project> projectList;
    private LayoutInflater layoutInflater;
    private ProjectContract.View projectView;

    public ProjectListAdapter(Context context, ProjectContract.View projectView) {
        this.context = context;
        projectList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.projectView = projectView;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProjectViewHolder(layoutInflater.inflate(R.layout.view_project_item, parent,
                false));
    }

    @Override
    public void onBindViewHolder(ProjectListAdapter.ProjectViewHolder holder, int position) {
        holder.bindViews(projectList.get(position));
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public void addAll(List<Project> projectList) {
        clear();
        this.projectList.addAll(projectList);
        this.notifyDataSetChanged();
    }

    public void clear() {
        if (projectList != null) {
            projectList.clear();
        }
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.iv_project_logo)
        ImageView ivProjectLogo;

        @BindView(R2.id.tv_project_name)
        TextView tvProjectName;

        ProjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("CheckResult")
        void bindViews(Project project) {
            tvProjectName.setText(project.getName());
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.fitCenter();
            Glide.with(context)
                    .asDrawable()
                    .apply(RequestOptions.circleCropTransform())
                    .load(project.getLogo())
                    .into(ivProjectLogo);
            itemView.setOnClickListener(v -> projectView.onProjectItemSelected(project));
        }
    }
}
