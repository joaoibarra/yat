package com.joaoibarra.yat.feature.projects.detail;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView;
import com.joaoibarra.yat.feature.R;
import com.joaoibarra.yat.feature.R2;
import com.joaoibarra.yat.feature.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ProjectDetailActivity extends BaseActivity {
    @BindView(R2.id.navigation_view)
    BottomNavigationView navigationView;

    @BindView(R2.id.container_fragment)
    FrameLayout containerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RxBottomNavigationView
                .itemSelections(navigationView)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(menuItem -> setFragmentByMenu(menuItem));
    }

    public void setFragmentByMenu(MenuItem menuItemu) {
        if(menuItemu.getItemId() == R.id.navigation_tasks) {
            setFragment(new TaskListFragment());
        }else if(menuItemu.getItemId() == R.id.navigation_overview) {
            setFragment(new TaskListFragment());
        }else if(menuItemu.getItemId() == R.id.navigation_messages) {
            setFragment(new TaskListFragment());
        }else if(menuItemu.getItemId() == R.id.navigation_milestones) {
            setFragment(new TaskListFragment());
        }else if(menuItemu.getItemId() == R.id.navigation_more) {
            setFragment(new TaskListFragment());
        }else{
            setFragment(new TaskListFragment());
        }
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, fragment);
        if(getSupportFragmentManager().getBackStackEntryCount()!=0) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}