package com.joaoibarra.yat.feature;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.joaoibarra.yat.feature.base.Constants;
import com.joaoibarra.yat.feature.models.Project;
import com.joaoibarra.yat.feature.projects.detail.ProjectDetailActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ProjectDetailActivityTest {

    @Rule
    public IntentsTestRule<ProjectDetailActivity> mActivityTestRule = new IntentsTestRule<ProjectDetailActivity>(ProjectDetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, ProjectDetailActivity.class);
            Project project = new Project();
            project.setId("462923");
            result.putExtra(Constants.PROJECT_DETAIL, project);
            return result;
        }
    };

    @Before
    public void init() {
        mActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void projectDetailActivityTest() {
        onView(withId(R.id.rv_task_list)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_task_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.navigation_overview)));
        appCompatTextView.perform(click());

        onView(withId(R.id.rv_task_list)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_task_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}