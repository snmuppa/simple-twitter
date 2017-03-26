package com.fetherz.saim.twistertwit.activities;

import android.os.Bundle;

import com.fetherz.saim.twistertwit.R;
import com.fetherz.saim.twistertwit.application.TwitterApplication;
import com.fetherz.saim.twistertwit.models.client.Tweet;
import com.fetherz.saim.twistertwit.models.utils.TweetsUtil;
import com.fetherz.saim.twistertwit.services.TwitterClient;
import com.fetherz.saim.twistertwit.utils.LogUtil;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends BaseActivity {

    static final String TAG = "TimelineActivity";

    TwitterClient twitterClient;
    static final short START_PAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        twitterClient = TwitterApplication.getRestClient();
        //Testing the response
        populateTimeline(START_PAGE);
    }

    private void populateTimeline(long pageId) {

        twitterClient.getHomeTimeLine(pageId, new TextHttpResponseHandler(){

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                LogUtil.logW(TAG, "Http request failure with status code: " + statusCode + ". " + throwable.getMessage(), throwable);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                LogUtil.logI(TAG, responseString);

                List<Tweet> tweets = TweetsUtil.getTweetsFromJson(responseString);
                LogUtil.logD(TAG, tweets.toString());
            }
        });
    }
}
