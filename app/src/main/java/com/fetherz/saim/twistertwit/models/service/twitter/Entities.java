package com.fetherz.saim.twistertwit.models.service.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/25/17.
 */

public class Entities {
    static final String MEDIA = "media";

    @SerializedName(MEDIA)
    List<Media> mediaCollection;

    public List<Media> getMediaCollection() {
        return mediaCollection;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "mediaCollection=" + mediaCollection +
                '}';
    }
}
