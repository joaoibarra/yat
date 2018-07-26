package com.joaoibarra.yat.feature.projects.detail;

import com.joaoibarra.yat.feature.projects.ProjectScope;

import dagger.Subcomponent;

@ProjectScope
@Subcomponent(modules = {ProjectDetailModule.class})
public interface ProjectDetailComponent {
    void inject(TaskListFragment taskListFragment);
}
