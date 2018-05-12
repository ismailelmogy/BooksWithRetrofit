package com.ismail.bookswithretrofit.model;

public class Item {
    public String kind;
    public VolumeInfo mVolumeInfos;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public VolumeInfo getVolumeInfos() {
        return mVolumeInfos;
    }

    public void setVolumeInfos(VolumeInfo volumeInfos) {
        mVolumeInfos = volumeInfos;
    }
}
