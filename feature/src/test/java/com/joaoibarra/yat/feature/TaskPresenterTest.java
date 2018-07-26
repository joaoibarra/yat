package com.joaoibarra.yat.feature;

import com.joaoibarra.yat.feature.api.ApiService;
import com.joaoibarra.yat.feature.mock.api.MockApiService;
import com.joaoibarra.yat.feature.models.ToDoItem;
import com.joaoibarra.yat.feature.tasks.TaskContract;
import com.joaoibarra.yat.feature.tasks.TaskPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.Mockito.mock;

public class TaskPresenterTest {
    @Mock
    private TaskContract.View taskView;

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
    public void validSetTaskData() {
        ApiService apiService = new MockApiService();
        TaskContract.Presenter taskPresenter = new TaskPresenter(taskView, apiService);
        ToDoItem toDoItemMock = mock(ToDoItem.class);
        taskPresenter.fetchTask(toDoItemMock);

        Mockito.verify(taskView, Mockito.times(1)).populateData(toDoItemMock);
    }
}

