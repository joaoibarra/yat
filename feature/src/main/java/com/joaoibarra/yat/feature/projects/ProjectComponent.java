package com.joaoibarra.yat.feature.projects;

import dagger.Subcomponent;

@ProjectScope
@Subcomponent(modules = {ProjectModule.class})
public interface ProjectComponent {
    void inject(ProjectListFragment projectListFragment);
}
