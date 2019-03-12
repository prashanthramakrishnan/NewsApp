package com.prashanth.newsapp.contract;

import com.prashanth.newsapp.model.TopHeadlinesResponse;

public interface NewsAPIContract {

    interface View {

        void callStarted();

        void callComplete();

        void onDataRetrievedSuccessfully(TopHeadlinesResponse topHeadlinesResponse);

        void callFailed(Throwable throwable);
    }

    interface Presenter {

        void loadData();

        void subscribe();

        void unsubscribe();

        void onDestroy();
    }

}
