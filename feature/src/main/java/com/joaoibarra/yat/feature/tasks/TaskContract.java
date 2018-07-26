package com.joaoibarra.yat.feature.tasks;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.joaoibarra.yat.feature.models.ToDoItem;

import java.util.List;

public class TaskContract {
    interface View {

        void initView();

        void onError(Throwable throwable);

        void populateData(ToDoItem toDoItem);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {

        void init();

        void fetchTask(ToDoItem toDoItem);

        List<PieEntry> getEntries(String progressValue);

        PieDataSet getPieDataSet(String progressValue, int[] colors);
    }
}
