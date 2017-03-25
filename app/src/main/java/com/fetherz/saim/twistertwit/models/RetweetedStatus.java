package com.fetherz.saim.twistertwit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sm032858 on 3/25/17.
 */

public class RetweetedStatus {
    static final String USER = "user";

    @SerializedName(USER)
    User user;

    public static String getUSER() {
        return USER;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RetweetedStatus{" +
                "user=" + user +
                '}';
    }
}
