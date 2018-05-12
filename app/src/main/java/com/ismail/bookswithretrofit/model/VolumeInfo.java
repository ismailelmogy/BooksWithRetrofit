package com.ismail.bookswithretrofit.model;

import com.google.gson.annotations.SerializedName;

public class VolumeInfo {

    @SerializedName("title")
    public String title;
    @SerializedName("subtitle")
    public String subtitle;
    @SerializedName("description")
    public String description;

    public VolumeInfo(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
