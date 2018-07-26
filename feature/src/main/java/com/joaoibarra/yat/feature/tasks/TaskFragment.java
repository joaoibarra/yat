package com.joaoibarra.yat.feature.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.base.BaseApplication;
import com.joaoibarra.yat.feature.base.Constants;
import com.joaoibarra.yat.feature.models.ToDoItem;
import com.joaoibarra.yat.feature.projects.ProjectListAdapter;
import com.joaoibarra.yat.feature.projects.ProjectListPresenter;
import com.joaoibarra.yat.feature.projects.ProjectModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TaskFragment extends Fragment implements TaskContract.View{

    @BindView(R2.id.fab_animation_progress)
    FloatingActionButton fabAnimationProgress;

    @BindView(R2.id.tv_progres_bar)
    AppCompatTextView tvProgressBar;

    @BindView(R2.id.cl_task)
    ConstraintLayout clTask;

    @BindView(R2.id.iv_user_logo)
    ImageView ivUserLogo;

    @BindView(R2.id.tv_task_content)
    TextView tvTaskContent;

    @BindView(R2.id.tv_task_list_name)
    TextView tvTaskListName;

    @BindView(R2.id.tv_due_date)
    TextView tvDueDate;

    @BindView(R2.id.chart)
    PieChart pieChart;

    @Inject
    TaskPresenter presenter;

    Unbinder unbinder;

    @Inject
    ApiService apiService;

    ToDoItem toDoItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toDoItem = getActivity().getIntent().getParcelableExtra(Constants.TASK_DETAIL);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newTaskComponent(new TaskModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
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
        presenter.fetchTask(toDoItem);
    }

    @Override
    public void onError(Throwable throwable) {
        hideLoading();
        Snackbar.make(tvProgressBar, R.string.error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void populateData(ToDoItem toDoItem) {
        hideLoading();

        tvTaskContent.setText(toDoItem.getContent());
        tvTaskListName.setText(toDoItem.getTodoListName());
        tvDueDate.setText(toDoItem.getFormatDueDate());
        Glide.with(getContext())
                .asDrawable()
                .apply(RequestOptions.circleCropTransform())
                .load(toDoItem.getCreatorAvatarUrl())
                .into(ivUserLogo);

        int[] colors = new int[]{
                ContextCompat.getColor(getActivity(), com.joaoibarra.yat.R.color.colorAccent),
                ContextCompat.getColor(getActivity(), com.joaoibarra.yat.R.color.gray)};

        PieData data = new PieData(presenter.getPieDataSet(toDoItem.getProgress(), colors));
        pieChart.setData(data);
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.animateY(1000);
        pieChart.setTouchEnabled(false);
        pieChart.invalidate();
    }

    @Override
    public void showLoading() {
        clTask.setVisibility(View.GONE);
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
        clTask.setVisibility(View.VISIBLE);
    }
}
