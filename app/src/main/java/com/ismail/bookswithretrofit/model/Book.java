package com.ismail.bookswithretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("kind")
    public String kind;
    @SerializedName("totalItems")
    public int totalItem;
    @SerializedName("items")
    public List<Item> items;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
