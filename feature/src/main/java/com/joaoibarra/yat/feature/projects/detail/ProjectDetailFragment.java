package com.joaoibarra.yat.feature.projects.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.joaoibarra.yat.feature.Constants;
import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.base.BaseApplication;
import com.joaoibarra.yat.feature.models.Project;
import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProjectDetailFragment extends Fragment implements ProjectDetailContract.View{

    @BindView(R2.id.rv_task_list)
    RecyclerView rvTaskList;

    @BindView(R2.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R2.id.tv_progres_bar)
    AppCompatTextView tvProgressBar;

    @BindView(R2.id.fab_animation_progress)
    FloatingActionButton fabAnimationProgress;

    Unbinder unbinder;

    @Inject
    ProjectDetailPresenter presenter;

    Project project;

    private TaskListAdapter taskListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        project = getActivity().getIntent().getParcelableExtra(Constants.PROJECT_DETAIL);
        ((BaseApplication)getActivity().getApplication())
                .getAppComponent()
                .newProjectDetailComponent(new ProjectDetailModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.init();
    }


    @Override
    public void initView() {
        taskListAdapter = new TaskListAdapter(getContext(), this);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvTaskList.setLayoutManager(llm);
        rvTaskList.setAdapter(taskListAdapter);
        presenter.fetchTasks(project.getId());
    }

    @Override
    public void populateData(List<ToDoItem> toDoItemList) {
        taskListAdapter.addAll(toDoItemList);
        hideLoading();
    }

    @Override
    public void onError(Throwable throwable) {
        hideLoading();
        Snackbar.make(tvProgressBar, R.string.error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        rvTaskList.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        tvProgressBar.setVisibility(View.VISIBLE);
        fabAnimationProgress.setVisibility(View.VISIBLE);
        Animation pulse = AnimationUtils.loadAnimation(getContext(), R.anim.pulse);
        fabAnimationProgress.startAnimation(pulse);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        tvProgressBar.setVisibility(View.GONE);
        fabAnimationProgress.clearAnimation();
        fabAnimationProgress.setVisibility(View.GONE);
        rvTaskList.setVisibility(View.VISIBLE);
    }
}
