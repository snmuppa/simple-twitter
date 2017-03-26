package com.fetherz.saim.twistertwit.models.utils;

import com.fetherz.saim.twistertwit.database.utils.DBFlowExclusionStrategy;
import com.fetherz.saim.twistertwit.models.client.Tweet;
import com.fetherz.saim.twistertwit.models.client.User;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for Twitter models
 * @author Sai Muppa
 */
public class TweetsUtil {

    /**
     * Deserializes json response into a collection of client understandable objects of type {@link com.fetherz.saim.twistertwit.models.client.Tweet}
     * @param jsonResponseString
     * @return Collection of {@link com.fetherz.saim.twistertwit.models.client.Tweet} objects
     */
    public static List<Tweet> getTweetsFromJson(String jsonResponseString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy[]{new DBFlowExclusionStrategy()});

        Gson gson = gsonBuilder.create();
        List<com.fetherz.saim.twistertwit.models.service.twitter.Tweet> serviceTweets;
        serviceTweets = gson.fromJson(jsonResponseString,
                new TypeToken<List<com.fetherz.saim.twistertwit.models.service.twitter.Tweet>>(){}.getType());

        return transposeServiceTweetsToClientTweets(serviceTweets);
    }

    /**
     * Transposes a collection service Tweet model to a collection of client Tweet models
     * @param serviceTweets
     * @return Collection of {@link com.fetherz.saim.twistertwit.models.client.Tweet} objects
     */
    public static List<Tweet> transposeServiceTweetsToClientTweets(List<com.fetherz.saim.twistertwit.models.service.twitter.Tweet> serviceTweets){
        List<Tweet> clientTweets = new ArrayList<>();

        if(serviceTweets != null) {
            for (com.fetherz.saim.twistertwit.models.service.twitter.Tweet serviceTweet: serviceTweets) {
                clientTweets.add(transposeServiceTweetToClientTweet(serviceTweet));
            }
        }

        return clientTweets;
    }

    /**
     * Transposes the service Tweet model to client Tweet model
     * @param serviceTweet
     * @return Object of type {@link com.fetherz.saim.twistertwit.models.client.Tweet}
     */
    public static Tweet transposeServiceTweetToClientTweet(com.fetherz.saim.twistertwit.models.service.twitter.Tweet serviceTweet) {
        if(serviceTweet != null) {
            return new Tweet.TweetBuilder(serviceTweet.getTweetId())
                    .setTweetIdString(serviceTweet.getTweetIdString())
                    .setCreatedAt(serviceTweet.getCreatedAt())
                    .setText(serviceTweet.getText())
                    .setRetweetCount(serviceTweet.getRetweetCount())
                    .setFavouriteCount(serviceTweet.getFavouriteCount())
                    .setFavorited(serviceTweet.getFavorited())
                    .setReTweeted(serviceTweet.getReTweeted())
                    .setUser(transposeServiceUserToClientUser(serviceTweet.getUser()))
                    .setHasRetweetStatus(serviceTweet.getHasRetweetStatus())
                    .setMediaType(serviceTweet.getMediaType())
                    .setMediaUrl(serviceTweet.getMediaUrl())
                    .setVideoUrl(serviceTweet.getVideoUrl())
                    .setMediaContentType(serviceTweet.getMediaContentType())
                    .createTweet();
        }

        return  null;
    }


    /**
     * Transposes the service User model to client User model
     * @param serviceUser
     * @return Object of type {@link com.fetherz.saim.twistertwit.models.client.User}
     */
    public static User transposeServiceUserToClientUser(com.fetherz.saim.twistertwit.models.service.twitter.User serviceUser){
        if(serviceUser != null) {
            return new User.UserBuilder(serviceUser.getUserId())
                    .setUserIdString(serviceUser.getUserIdString())
                    .setProfileImageUrl(serviceUser.getProfileImageUrl())
                    .setName(serviceUser.getName())
                    .setScreenName(serviceUser.getScreenName())
                    .createUser();
        }

        return null;
    }
}
