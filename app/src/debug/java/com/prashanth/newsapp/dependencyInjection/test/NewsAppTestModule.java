package com.prashanth.newsapp.dependencyInjection.test;

import android.app.Application;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prashanth.newsapp.dependencyInjection.NetworkDaggerModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NewsAppTestModule extends NetworkDaggerModule {

    public NewsAppTestModule(String baseUrl) {
        super(baseUrl);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitBuilder(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://localhost:8080")
                .client(okHttpClient)
                .build();
    }

}
