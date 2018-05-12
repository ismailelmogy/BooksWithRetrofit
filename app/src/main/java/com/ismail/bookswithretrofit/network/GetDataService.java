package com.ismail.bookswithretrofit.network;

import android.content.ClipData;

import com.ismail.bookswithretrofit.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("books/v1/volumes?q=cooking")
    Call<List<Item>> getAllBooks();
//    Call<ResponseBody> volumes(@Query("q") String q);

}
