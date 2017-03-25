package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/25/17.
 */

public class ExtendedEntities {
    static final String MEDIA = "media";

    @SerializedName(MEDIA)
    List<Media> mediaCollection;

    public static String getMEDIA() {
        return MEDIA;
    }

    public List<Media> getMediaCollection() {
        return mediaCollection;
    }

    public void setMediaCollection(List<Media> mediaCollection) {
        this.mediaCollection = mediaCollection;
    }

    @Override
    public String toString() {
        return "ExtendedEntities{" +
                "mediaCollection=" + mediaCollection +
                '}';
    }
}
