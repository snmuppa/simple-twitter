package com.fetherz.saim.twistertwit.models.client;

import org.parceler.Parcel;

/**
 * Created by sm032858 on 3/25/17.
 */

@Parcel(analyze={Tweet.class})
public class User {
    public static class UserBuilder {
        private long userId;
        private String userIdString;
        private String name;
        private String screenName;
        private String profileImageUrl;

        public UserBuilder(long userId){
            this.userId = userId;
        }

        public UserBuilder setUserIdString(String userIdString) {
            this.userIdString = userIdString;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setScreenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public UserBuilder setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        public User createUser() {
            return new User(userId, userIdString, name, screenName, profileImageUrl);
        }
    }

    long userId;

    String userIdString;

    private String name;

    private String screenName;

    private String profileImageUrl;

    public User() { }

    private User(long userId, String userIdString, String name, String screenName, String profileImageUrl) {
        this.userId = userId;
        this.userIdString = userIdString;
        this.name = name;
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserIdString() {
        return userIdString;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
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
