package com.prashanth.newsapp.dependencyInjection;

import com.prashanth.newsapp.activity.MainActivity;

public interface NewsAppDaggerGraph {

    void inject(MainActivity mainActivity);

}
