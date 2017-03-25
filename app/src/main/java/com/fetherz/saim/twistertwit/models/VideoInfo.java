package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sm032858 on 3/25/17.
 */

public class VideoInfo {
    static final String ASPECT_RATIO = "aspect_ratio";
    static final String VARIANTS = "variants";
    static final String DURATION = "duration_millis";

    @SerializedName(ASPECT_RATIO)
    public List<Integer> aspectRatio = null;

    @SerializedName(DURATION)
    public int durationMillis;

    @SerializedName(VARIANTS)
    public List<Variant> variants = null;

    public static String getAspectRatio() {
        return ASPECT_RATIO;
    }

    public void setAspectRatio(List<Integer> aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public int getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(int durationMillis) {
        this.durationMillis = durationMillis;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public static String getVARIANTS() {
        return VARIANTS;
    }

    public static String getDURATION() {
        return DURATION;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "aspectRatio=" + aspectRatio +
                ", durationMillis=" + durationMillis +
                ", variants=" + variants +
                '}';
    }
}
