package com.prashanth.newsapp.presenter;

import androidx.annotation.NonNull;
import com.prashanth.newsapp.BuildConfig;
import com.prashanth.newsapp.contract.NewsAPIContract;
import com.prashanth.newsapp.model.TopHeadlinesResponse;
import com.prashanth.newsapp.network.NewsApi;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsAPIPresenter implements NewsAPIContract.Presenter {

    @NonNull
    private NewsApi newsApi;

    @NonNull
    private CompositeDisposable compositeDisposable;

    private NewsAPIContract.View view;

    public NewsAPIPresenter(@NonNull NewsApi newsApi, @NonNull NewsAPIContract.View view) {
        this.newsApi = newsApi;
        compositeDisposable = new CompositeDisposable();
        this.view = view;
    }

    @Override
    public void loadData() {
        view.callStarted();
        compositeDisposable.clear();
        Disposable disposable = newsApi
                .getHeadlines(BuildConfig.SOURCE, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<TopHeadlinesResponse>() {
                    @Override
                    public void onNext(TopHeadlinesResponse topHeadlinesResponse) {
                        view.onDataRetrievedSuccessfully(topHeadlinesResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.callFailed(e);
                    }

                    @Override
                    public void onComplete() {
                        view.callComplete();
                    }
                });

        compositeDisposable.add(disposable);
    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
