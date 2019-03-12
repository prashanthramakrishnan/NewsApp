package com.prashanth.newsapp.dependencyInjection;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application mApplication) {
        this.application = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}
