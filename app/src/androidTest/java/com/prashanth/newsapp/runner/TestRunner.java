package com.prashanth.newsapp.runner;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import androidx.test.runner.AndroidJUnitRunner;
import com.prashanth.newsapp.NewsApplication;
import com.prashanth.newsapp.NewsBaseApplication;
import com.prashanth.newsapp.NewsTestApplication;

public class TestRunner extends AndroidJUnitRunner {

    @Override
    public void onCreate(Bundle arguments) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        super.onCreate(arguments);
    }

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, NewsTestApplication.class.getName(), context);
    }

}
