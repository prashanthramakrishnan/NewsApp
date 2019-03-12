package com.prashanth.newsapp;

import com.prashanth.newsapp.dependencyInjection.NewsAppDebugModule;
import com.prashanth.newsapp.dependencyInjection.test.NewsAppTestModule;
import timber.log.Timber;

public class NewsTestApplication extends NewsApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        component = daggerComponent(this)
                .newsAppDebugModule(new NewsAppDebugModule())
                .networkDaggerModule(new NewsAppTestModule("http://localhost:8080"))
                .build();
        Timber.plant(new Timber.DebugTree());
    }
}
