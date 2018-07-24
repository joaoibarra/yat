package com.joaoibarra.yat.feature.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.base.BaseApplication;
import com.joaoibarra.yat.feature.models.Project;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProjectListFragment extends Fragment implements ProjectContract.View {

    @BindView(R2.id.rv_project_list)
    RecyclerView rvProjectList;

    @BindView(R2.id.progress_bar)
    ProgressBar progressBar;

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
        View view = inflater.inflate(R.layout.fragment_project_list, container, false);
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

    }

    @Override
    public void onError(Throwable throwable) {
        hideLoading();
        Snackbar.make(tvProgressBar, R.string.error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        rvProjectList.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        tvProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        tvProgressBar.setVisibility(View.GONE);
        rvProjectList.setVisibility(View.VISIBLE);
    }
}
