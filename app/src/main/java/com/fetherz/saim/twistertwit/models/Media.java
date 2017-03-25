package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/25/17.
 */

public class Media {
    static final String MEDIA_ID = "id";
    static final String MEDIA_ID_STRING = "id_str";
    static final String TYPE = "type";
    static final String MEDIA_URL = "media_url";
    static final String VIDEO_INFO = "video_info";

    @SerializedName(MEDIA_ID)
    long mediaId;

    @SerializedName(MEDIA_ID_STRING)
    String mediaIdString;

    @SerializedName(TYPE)
    String type;

    @SerializedName(MEDIA_URL)
    String mediaURl;

    @SerializedName(VIDEO_INFO)
    VideoInfo videoInfo;

    public static String getMediaId() {
        return MEDIA_ID;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public static String getMediaIdString() {
        return MEDIA_ID_STRING;
    }

    public void setMediaIdString(String mediaIdString) {
        this.mediaIdString = mediaIdString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaURl() {
        return mediaURl;
    }

    public void setMediaURl(String mediaURl) {
        this.mediaURl = mediaURl;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public static String getMediaUrl() {
        return MEDIA_URL;
    }

    public static String getVideoInfo() {
        return VIDEO_INFO;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", mediaIdString='" + mediaIdString + '\'' +
                ", type='" + type + '\'' +
                ", mediaURl='" + mediaURl + '\'' +
                ", videoInfo=" + videoInfo +
                '}';
    }
}
