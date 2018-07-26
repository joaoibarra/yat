package com.joaoibarra.yat.feature.projects.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
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
    private ProjectDetailContract.TaskView projectDetailTaskView;

    public TaskListAdapter(Context context, ProjectDetailContract.TaskView projectDetailTaskView) {
        this.context = context;
        toDoItemList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.projectDetailTaskView = projectDetailTaskView;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskViewHolder(layoutInflater.inflate(R.layout.view_task_item, parent,
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

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("CheckResult")
        void bindViews(ToDoItem toDoItem) {
            tvTaskContent.setText(toDoItem.getContent());
            tvTaskListName.setText(toDoItem.getTodoListName());
            tvDueDate.setText(toDoItem.getFormatDueDate());
            Glide.with(context)
                    .asDrawable()
                    .apply(RequestOptions.circleCropTransform())
                    .load(toDoItem.getCreatorAvatarUrl())
                    .into(ivUserLogo);

            PieData data = new PieData(getPieDataSet(toDoItem.getProgress()));
            pieChart.setData(data);
            pieChart.getLegend().setEnabled(false);
            pieChart.getDescription().setEnabled(false);
            pieChart.setDrawEntryLabels(false);
            pieChart.animateY(1000);
            pieChart.setTouchEnabled(false);
            pieChart.invalidate();

            itemView.setOnClickListener(v -> projectDetailTaskView.onToDoItemSelected(toDoItem));
        }

        private List<PieEntry> getEntries(String progressValue){
            List<PieEntry> entries = new ArrayList<>();

            float progress = Float.valueOf(progressValue);

            entries.add(new PieEntry(progress));
            entries.add(new PieEntry(100f-progress));
            return entries;
        }

        private PieDataSet getPieDataSet(String progressValue){
            PieDataSet set = new PieDataSet(getEntries(progressValue), null);
            set.setDrawValues(false);

            set.setColors(new int[]{ContextCompat.getColor(context, com.joaoibarra.yat.R.color.colorAccent),ContextCompat.getColor(context, com.joaoibarra.yat.R.color.gray)});
            return set;
        }
    }
}
