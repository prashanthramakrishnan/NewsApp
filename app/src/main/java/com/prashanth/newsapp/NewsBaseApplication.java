package com.prashanth.newsapp;

import android.app.Application;
import android.content.Context;
import com.prashanth.newsapp.dependencyInjection.ApplicationModule;
import com.prashanth.newsapp.dependencyInjection.DaggerNewsAppDaggerComponent;
import com.prashanth.newsapp.dependencyInjection.NetworkDaggerModule;
import com.prashanth.newsapp.dependencyInjection.NewsAppDaggerComponent;
import timber.log.Timber;

public abstract class NewsBaseApplication extends Application {

    public static NewsAppDaggerComponent component;

    public DaggerNewsAppDaggerComponent.Builder daggerComponent(NewsBaseApplication application) {
        return DaggerNewsAppDaggerComponent.builder()
                .networkDaggerModule(new NetworkDaggerModule(BuildConfig.ENDPOINT))
                .applicationModule(new ApplicationModule(this));
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
