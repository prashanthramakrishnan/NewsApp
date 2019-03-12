package com.prashanth.newsapp;

import com.prashanth.newsapp.dependencyInjection.NewsAppReleaseModule;

public class NewsApplication extends NewsBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        component = daggerComponent(this)
                .newsAppReleaseModule(new NewsAppReleaseModule())
                .build();
    }
}