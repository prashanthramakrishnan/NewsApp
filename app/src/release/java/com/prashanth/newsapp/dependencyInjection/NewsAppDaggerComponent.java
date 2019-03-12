package com.prashanth.newsapp.dependencyInjection;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { NetworkDaggerModule.class, NewsAppReleaseModule.class, ApplicationModule.class})
public interface NewsAppDaggerComponent extends NewsAppDaggerGraph {

}