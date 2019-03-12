package com.prashanth.newsapp;

import com.prashanth.newsapp.contract.NewsAPIContract;
import com.prashanth.newsapp.model.Articles;
import com.prashanth.newsapp.model.TopHeadlinesResponse;
import com.prashanth.newsapp.dependencyInjection.test.MockNewsAPI;
import com.prashanth.newsapp.network.NewsApi;
import com.prashanth.newsapp.presenter.NewsAPIPresenter;
import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class NewsAPIPresenterTest {

    @Mock
    private NewsAPIContract.View view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void getDataAndLoadView() {
        NewsApi newsApi = new MockNewsAPI();
        NewsAPIPresenter presenter = new NewsAPIPresenter(newsApi, view);
        presenter.loadData();
        Mockito.verify(view, times(1)).callStarted();
        Mockito.verify(view, times(1)).onDataRetrievedSuccessfully(any());
        Mockito.verify(view, times(1)).callComplete();
    }

}