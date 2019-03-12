package com.prashanth.newsapp.dependencyInjection;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NewsAppDebugModule {

    private static final int TIMEOUT = 60;

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        HttpLoggingInterceptor debugInterceptor = new HttpLoggingInterceptor();
        debugInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        client.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        client.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        client.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        client.addInterceptor(debugInterceptor);
        return client.build();
    }

}
