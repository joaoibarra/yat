package com.joaoibarra.yat.feature.tasks;

import android.os.Bundle;

import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.base.BaseActivity;

public class TaskActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
