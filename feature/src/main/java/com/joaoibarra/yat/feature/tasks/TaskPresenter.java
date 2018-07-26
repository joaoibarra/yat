package com.joaoibarra.yat.feature.tasks;

import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.ArrayList;
import java.util.List;

public class TaskPresenter implements TaskContract.Presenter {
    private TaskContract.View taskView;
    private boolean isUpdating;

    private ApiService apiService;

    public TaskPresenter(TaskContract.View taskView, ApiService apiService) {
        this.taskView = taskView;
        this.apiService = apiService;
    }

    @Override
    public void init() {
        taskView.initView();
    }

    @Override
    public void fetchTask(ToDoItem toDoItem) {
        taskView.showLoading();
        taskView.populateData(toDoItem);
    }

    @Override
    public List<PieEntry> getEntries(String progressValue){
        List<PieEntry> entries = new ArrayList<>();

        float progress = Float.valueOf(progressValue);

        entries.add(new PieEntry(progress));
        entries.add(new PieEntry(100f-progress));
        return entries;
    }

    @Override
    public PieDataSet getPieDataSet(String progressValue, int[] colors){
        PieDataSet set = new PieDataSet(getEntries(progressValue), null);
        set.setDrawValues(false);

        set.setColors(colors);
        return set;
    }
}
