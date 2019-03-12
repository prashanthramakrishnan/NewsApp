package com.prashanth.newsapp.dependencyInjection.test;

import com.prashanth.newsapp.model.TopHeadlinesResponse;
import com.prashanth.newsapp.network.NewsApi;
import io.reactivex.Observable;

public class MockNewsAPI implements NewsApi {

    @Override
    public Observable<TopHeadlinesResponse> getHeadlines(String sources, String apiKey) {
        TopHeadlinesResponse topHeadlinesResponse = new TopHeadlinesResponse();
        return Observable.just(topHeadlinesResponse);

    }
}