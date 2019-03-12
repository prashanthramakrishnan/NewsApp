package com.prashanth.newsapp;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertTrue;

import android.content.Intent;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.prashanth.newsapp.activity.ArticleWebViewActivity;
import com.prashanth.newsapp.activity.MainActivity;
import com.robotium.solo.Solo;
import java.io.IOException;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import timber.log.Timber;

@RunWith(AndroidJUnit4.class)
public class FlowTest {

    private MockWebServer server;

    private Solo solo;

    private static final String TEXT = "Power";

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() throws Exception {
        setupServer();
        solo = new Solo(getInstrumentation(), rule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        server.shutdown();
    }

    @Test()
    public void startActivityTest() throws Exception {

        //Launch MainActivity with MockServer running
        rule.launchActivity(new Intent());

        //wait for 3 seconds
        introduceDelay(3000L);

        //Click on the text Power to launch ArticleWebViewActivity
        solo.clickOnText(TEXT);

        //wait for 4 seconds
        introduceDelay(4000L);

        assertTrue(solo.waitForActivity(ArticleWebViewActivity.class.getSimpleName()));

    }

    private void setupServer() throws Exception {

        server = new MockWebServer();
        Dispatcher dispatcher = new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

                if (request.getMethod().equals("GET")) {
                    String newsAPIResponse = null;
                    try {
                        newsAPIResponse = IOUtils.toString(getInstrumentation().getContext().getResources().getAssets().open("json/response_json.json"));
                        return new MockResponse().setResponseCode(200).setBody(newsAPIResponse);
                    } catch (IOException e) {
                        Timber.e(e);
                    }
                }
                return null;
            }
        };

        server.setDispatcher(dispatcher);
        server.start(8080);

    }

    private void introduceDelay(long timeout) {
        synchronized (this) {
            try {
                this.wait(timeout);
            } catch (InterruptedException e) {
                Timber.e(e);
            }
        }
    }

}
