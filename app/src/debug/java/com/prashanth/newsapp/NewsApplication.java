package com.prashanth.newsapp;

import com.prashanth.newsapp.dependencyInjection.NewsAppDebugModule;
import timber.log.Timber;

public class NewsApplication extends NewsBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        component = daggerComponent(this)
                .newsAppDebugModule(new NewsAppDebugModule())
                .build();
        Timber.plant(new Timber.DebugTree());
    }
}