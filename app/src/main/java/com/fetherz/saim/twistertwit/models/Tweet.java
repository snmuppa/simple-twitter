package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/21/17.
 */

public class Tweet {
    static final String CREATED_AT = "created_at";
    static final String TWEET_ID_STR = "id_str";
    static final String TWEET_ID = "id";
    static final String TEXT = "text";
    static final String FAVOURITE_COUNT = "favorite_count";
    static final String RETWEET_COUNT = "retweet_count";
    static final String FAVORITED = "favorited";
    static final String RETWEETED = "retweeted";
    static final String ENTITIES = "entities";
    static final String EXTENDED_ENTITIES = "extended_entities";
    static final String RETWEETED_STATUS = "retweeted_status";
    static final String USER = "user";

    static final String VIDEO_MP4 = "video/mp4";

    static final String COLUMN_CREATED_AT = "CreatedAt";
    static final String COLUMN_ID_STR = "Id";
    static final String COLUMN_TEXT = "Text";
    static final String COLUMN_FAVOURITE_COUNT = "FavoriteCount";
    static final String COLUMN_RETWEET_COUNT = "RetweetCount";
    static final String COLUMN_MEDIA = "Media";
    static final String COLUMN_TYPE = "Type";
    static final String COLUMN_MEDIA_URL = "MediaUrl";
    static final String COLUMN_EXTENDED_ENTITIES = "ExtendedEntities";
    static final String COLUMN_VIDEO = "Video";
    static final String COLUMN_PHOTO = "photo";
    static final String COLUMN_VIDEO_INFO = "VideoInfo";
    static final String COLUMN_VARIANTS = "Variants";
    static final String COLUMN_CONTENT_TYPE = "ContentType";
    static final String COLUMN_URL = "Url";
    static final String COLUMN_USER = "User";
    static final String COLUMN_ENTITIES = "Entities";
    static final String COLUMN_VIDEO_MP4 = "VideoMp4";

    @SerializedName(TWEET_ID_STR)
    String tweetIdString;

    @SerializedName(TWEET_ID)
    long tweetId;

    @SerializedName(CREATED_AT)
    String createdAt;

    @SerializedName(TEXT)
    String text;

    @SerializedName(RETWEET_COUNT)
    String retweetCount;

    @SerializedName(FAVOURITE_COUNT)
    String favouriteCount;

    @SerializedName(FAVORITED)
    Boolean favorited;

    @SerializedName(RETWEETED)
    Boolean reTweeted;

    @SerializedName(ENTITIES)
    Entities entities;

    @SerializedName(EXTENDED_ENTITIES)
    ExtendedEntities extendedEntities;

    @SerializedName(RETWEETED_STATUS)
    RetweetedStatus retweetedStatus;

    @SerializedName(USER)
    User user;

    Boolean hasRetweetStatus;

    String twitterUrl;

    String mediaType;

    String mediaUrl;

    String videoUrl;

    String mediaContentType;

    public Tweet() {
        super();
    }


    public String getTweetIdString() {
        return tweetIdString;
    }

    public void setTweetIdString(String tweetIdString) {
        this.tweetIdString = tweetIdString;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(String retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(String favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getReTweeted() {
        return reTweeted;
    }

    public void setReTweeted(Boolean reTweeted) {
        this.reTweeted = reTweeted;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public ExtendedEntities getExtendedEntities() {
        return extendedEntities;
    }

    public void setExtendedEntities(ExtendedEntities extendedEntities) {
        this.extendedEntities = extendedEntities;
    }

    public RetweetedStatus getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(RetweetedStatus retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getHasRetweetStatus() {
        return hasRetweetStatus;
    }

    public void setHasRetweetStatus(Boolean hasRetweetStatus) {
        this.hasRetweetStatus = hasRetweetStatus;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getMediaContentType() {
        return mediaContentType;
    }

    public void setMediaContentType(String mediaContentType) {
        this.mediaContentType = mediaContentType;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetIdString='" + tweetIdString + '\'' +
                ", tweetId=" + tweetId +
                ", createdAt='" + createdAt + '\'' +
                ", text='" + text + '\'' +
                ", retweetCount='" + retweetCount + '\'' +
                ", favouriteCount='" + favouriteCount + '\'' +
                ", favorited=" + favorited +
                ", reTweeted=" + reTweeted +
                ", entities=" + entities +
                ", extendedEntities=" + extendedEntities +
                ", retweetedStatus=" + retweetedStatus +
                ", user=" + user +
                ", hasRetweetStatus=" + hasRetweetStatus +
                ", twitterUrl='" + twitterUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", mediaContentType='" + mediaContentType + '\'' +
                '}';
    }
}
