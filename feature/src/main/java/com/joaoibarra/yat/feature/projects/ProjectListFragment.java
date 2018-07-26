package com.joaoibarra.yat.feature.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.joaoibarra.yat.feature.base.Constants;
import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.base.BaseApplication;
import com.joaoibarra.yat.feature.models.Project;
import com.joaoibarra.yat.feature.projects.detail.ProjectDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProjectListFragment extends Fragment implements ProjectContract.View {

    @BindView(R2.id.rv_project_list)
    RecyclerView rvProjectList;

    @BindView(R2.id.fab_animation_progress)
    FloatingActionButton fabAnimationProgress;

    @BindView(R2.id.tv_progres_bar)
    AppCompatTextView tvProgressBar;

    Unbinder unbinder;

    @Inject
    ProjectListPresenter presenter;

    private ProjectListAdapter projectListAdapter;

    @Inject
    ApiService apiService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newProjectComponent(new ProjectModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void initView() {
        projectListAdapter = new ProjectListAdapter(getContext(), this);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvProjectList.setLayoutManager(llm);
        rvProjectList.setAdapter(projectListAdapter);
        presenter.fetchProjects();
    }

    @Override
    public void populateData(List<Project> projectList) {
        projectListAdapter.addAll(projectList);
        hideLoading();
    }

    @Override
    public void onProjectItemSelected(Project project) {
        Intent intent = new Intent(getActivity(), ProjectDetailActivity.class);
        intent.putExtra(Constants.PROJECT_DETAIL, project);
        startActivity(intent);
    }

    @Override
    public void onError(Throwable throwable) {
        hideLoading();
        Snackbar.make(tvProgressBar, R.string.error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        rvProjectList.setVisibility(View.GONE);
        tvProgressBar.setVisibility(View.VISIBLE);
        fabAnimationProgress.setVisibility(View.VISIBLE);
        Animation pulse = AnimationUtils.loadAnimation(getContext(), R.anim.pulse);
        fabAnimationProgress.startAnimation(pulse);
    }

    @Override
    public void hideLoading() {
        tvProgressBar.setVisibility(View.GONE);
        fabAnimationProgress.clearAnimation();
        fabAnimationProgress.setVisibility(View.GONE);
        rvProjectList.setVisibility(View.VISIBLE);
    }
}
