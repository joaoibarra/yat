package com.joaoibarra.yat.feature;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.mock.api.MockApiService;
import com.joaoibarra.yat.feature.projects.ProjectContract;
import com.joaoibarra.yat.feature.projects.ProjectListPresenter;
import com.joaoibarra.yat.feature.projects.detail.ProjectDetailContract;
import com.joaoibarra.yat.feature.projects.detail.TaskListPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.ArgumentMatchers.any;

@RunWith(JUnit4.class)
public class TaskListPresenterTest {
    @Mock
    private ProjectDetailContract.TaskView taskView;

    @BeforeClass
    public static void setupRxSchedulers() {
        Scheduler onInit = new Scheduler() {
            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
                return super.scheduleDirect(run, delay, unit);
            }
        };
        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> onInit);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> onInit);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> onInit);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> onInit);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> onInit);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        Mockito.validateMockitoUsage();
    }

    @Test
    public void validGetTaskResponseData() {
        ApiService apiService = new MockApiService();
        ProjectDetailContract.Presenter taskPresenter = new TaskListPresenter(taskView, apiService);
        taskPresenter.fetchTasks("462923");

        Mockito.verify(taskView, Mockito.times(1)).populateData(any());
    }
}
