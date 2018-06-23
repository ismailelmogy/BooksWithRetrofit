package com.ismail.bookswithretrofit.interfaces;

import android.content.ClipData;

import com.ismail.bookswithretrofit.model.BasicRepsonse;
import com.ismail.bookswithretrofit.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by praka on 12/24/2017.
 */

public interface BooksApi {

    @GET("/books/v1/volumes?q=cooking")
    Call<BasicRepsonse> getAllBooks();
//    Call<ResponseBody> volumes(@Query("q") String q);

}
