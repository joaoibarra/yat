package com.joaoibarra.yat.feature.projects;

import android.os.Bundle;

import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.base.BaseActivity;

public class ProjectListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

    }
}