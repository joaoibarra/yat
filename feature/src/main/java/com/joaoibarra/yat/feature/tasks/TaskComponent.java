package com.joaoibarra.yat.feature.tasks;

import com.joaoibarra.yat.feature.projects.ProjectScope;

import dagger.Subcomponent;

@ProjectScope
@Subcomponent(modules = {TaskModule.class})
public interface TaskComponent {
    void inject(TaskFragment taskFragment);
}
