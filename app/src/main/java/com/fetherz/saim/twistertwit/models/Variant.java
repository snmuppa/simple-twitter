package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/25/17.
 */

class Variant {
    static final String BITRATE = "bitrate";
    static final String CONTENT_TYPE = "content_type";
    static final String URL = "url";

    @SerializedName(BITRATE)
    public int bitrate;

    @SerializedName(CONTENT_TYPE)
    public String contentType;

    @SerializedName(URL)
    public String url;

    public static String getBITRATE() {
        return BITRATE;
    }

    public static String getContentType() {
        return CONTENT_TYPE;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static String getURL() {
        return URL;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "bitrate=" + bitrate +
                ", contentType='" + contentType + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
