package com.prashanth.newsapp.network;

import com.prashanth.newsapp.model.TopHeadlinesResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Observable<TopHeadlinesResponse> getHeadlines(@Query("sources") String sources, @Query("apiKey") String apiKey);
}
