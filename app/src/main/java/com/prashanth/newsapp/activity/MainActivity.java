package com.prashanth.newsapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.prashanth.newsapp.BuildConfig;
import com.prashanth.newsapp.NewsApplication;
import com.prashanth.newsapp.R;
import com.prashanth.newsapp.adapter.ArticleRecyclerViewAdapter;
import com.prashanth.newsapp.contract.NewsAPIContract;
import com.prashanth.newsapp.model.TopHeadlinesResponse;
import com.prashanth.newsapp.network.NewsApi;
import com.prashanth.newsapp.presenter.NewsAPIPresenter;
import javax.inject.Inject;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Inject
    Retrofit retrofit;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsApplication.component.inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        doAPICall();
    }

    @SuppressLint("CheckResult")
    private void doAPICall() {
        swipeRefreshLayout.setRefreshing(true);
        NewsApi newsApi = retrofit.create(NewsApi.class);
        NewsAPIPresenter newsAPIPresenter = new NewsAPIPresenter(newsApi, new NewsAPIContract.View() {
            @Override
            public void callStarted() {
                Timber.d("call started");
            }

            @Override
            public void callComplete() {
                swipeRefreshLayout.setRefreshing(false);
                Timber.d("call complete");
            }

            @Override
            public void onDataRetrievedSuccessfully(TopHeadlinesResponse topHeadlinesResponse) {
                Timber.d(topHeadlinesResponse.toString());
                if (!topHeadlinesResponse.getArticles().isEmpty()) {
                    ArticleRecyclerViewAdapter adapter = new ArticleRecyclerViewAdapter(MainActivity.this, topHeadlinesResponse.getArticles());
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(adapter);
                }
                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void callFailed(Throwable throwable) {
                swipeRefreshLayout.setRefreshing(false);
                Timber.e(throwable);
            }
        });
        newsAPIPresenter.loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        doAPICall();
    }
}
