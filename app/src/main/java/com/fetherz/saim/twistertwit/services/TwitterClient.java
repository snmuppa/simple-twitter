package com.fetherz.saim.twistertwit.services;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 *
 * This is the object responsible for communicating with a REST API.
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes:
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 *
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 *
 */
public class TwitterClient extends OAuthBaseClient {

    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
    public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
    public static final String REST_CONSUMER_KEY = "YtEc21QWU0try76qAvHq9Gayb";       // Change this
    public static final String REST_CONSUMER_SECRET = "REdnhUm1QvqaKAgdAYomyF93s4M3DbOzu7Xy7ykOW5JwrLkcNU"; // Change this
    public static final String REST_CALLBACK_URL = "oauth://droidgeddontweets"; // Change this (here and in manifest)

    public static final String GET_HOME_TIMELINE = "statuses/home_timeline.json";
    public static final String QUERY_PARAM_SINCE_ID = "since_id";
    public static final String QUERY_PARAM_MAX_ID = "max_id";

    public static final String GET_USER_TIMELINE = "statuses/home_timeline.json";
    public static final String QUERY_PARAM_COUNT = "count";

    public static final String UPDATE_STATUS = "statuses/update.json";
    public static final String QUERY_PARAM_STATUS = "status";
    public static final String QUERY_PARAM_REPLY_TO_STATUS_ID = "in_reply_to_status_id";

    public static final String ADD_FAVORITE = "favorites/create.json";
    public static final String REMOVE_FAVORITE = "favorites/destroy.json";
    public static final String QUERY_PARAM_ID = "id";

    public static final String ADD_RETWEET  = "statuses/retweet/%s/.json"; //format string to update the tweet id in the path
    public static final String GET_CURRENT_USER = "account/verify_credentials.json";
    public static final short TWEET_COUNT = 15;

    public TwitterClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }

    public void getHomeTimeLine(long sinceId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(GET_HOME_TIMELINE);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_COUNT, TWEET_COUNT);

        if(sinceId == 1){
            params.put(QUERY_PARAM_SINCE_ID, sinceId);
        }
        else {
            params.put(QUERY_PARAM_MAX_ID, sinceId);
        }

        getClient().get(apiUrl, params, asyncHttpResponseHandler);
    }

    public void getUserTimeLine(long sinceId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(GET_USER_TIMELINE);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_COUNT, TWEET_COUNT);

        if(sinceId == 1){
            params.put(QUERY_PARAM_SINCE_ID, sinceId);
        }
        else {
            params.put(QUERY_PARAM_MAX_ID, sinceId);
        }

        getClient().get(apiUrl, params, asyncHttpResponseHandler);
    }

    public void composeATweet(String text, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl  = getApiUrl(UPDATE_STATUS);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_STATUS, text);

        getClient().post(apiUrl, params, asyncHttpResponseHandler);
    }

    public void replyToStatus(String text, String replyToStatusId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(UPDATE_STATUS);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_REPLY_TO_STATUS_ID, replyToStatusId);
        params.put(QUERY_PARAM_STATUS, text);

        getClient().put(apiUrl, params, asyncHttpResponseHandler);
    }

    public void reTweet(String tweetId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(String.format(ADD_RETWEET, tweetId));

        getClient().post(apiUrl, null, asyncHttpResponseHandler);
    }

    public void favoriteATweet(String tweetId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(ADD_FAVORITE);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_ID, tweetId);

        getClient().put(apiUrl, params, asyncHttpResponseHandler);
    }

    public void unFavoriteATweet(String tweetId, AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(REMOVE_FAVORITE);

        RequestParams params = new RequestParams();
        params.put(QUERY_PARAM_ID, tweetId);

        getClient().put(apiUrl, params, asyncHttpResponseHandler);
    }

    public void getUser(AsyncHttpResponseHandler asyncHttpResponseHandler){
        String apiUrl = getApiUrl(GET_CURRENT_USER);
        getClient().get(apiUrl, null, asyncHttpResponseHandler);
    }

}
