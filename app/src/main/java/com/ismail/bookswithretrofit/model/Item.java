package com.ismail.bookswithretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public VolumeInfo getVolumeInfos() {
        return volumeInfo;
    }

    public void setVolumeInfos(VolumeInfo volumeInfos) {
        this.volumeInfo = volumeInfos;
    }
}
