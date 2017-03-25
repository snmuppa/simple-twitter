package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/25/17.
 */

public class User {
    final String USER_ID = "id";
    final String USER_ID_STRING = "created_at";
    final String USER_NAME = "name";
    final String USER_SCREEN_NAME = "screen_name";
    final String PROFILE_IMAGE_URL = "profile_image_url";

    @SerializedName(USER_ID)
    long userId;

    @SerializedName(USER_ID_STRING)
    String userIdString;

    @SerializedName(USER_NAME)
    private String name;

    @SerializedName(USER_SCREEN_NAME)
    private String screenName;

    @SerializedName(PROFILE_IMAGE_URL)
    private String profileImageUrl;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIdString() {
        return userIdString;
    }

    public void setUserIdString(String userIdString) {
        this.userIdString = userIdString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userIdString='" + userIdString + '\'' +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }
}
