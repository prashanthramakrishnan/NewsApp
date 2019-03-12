package com.prashanth.newsapp.dependencyInjection;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {NetworkDaggerModule.class, NewsAppDebugModule.class, ApplicationModule.class})
public interface NewsAppDaggerComponent extends NewsAppDaggerGraph {

}