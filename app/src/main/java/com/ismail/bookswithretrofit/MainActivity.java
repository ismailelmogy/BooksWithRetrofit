package com.ismail.bookswithretrofit;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ismail.bookswithretrofit.MainActivityFeature.MainActivityComponent;
import com.ismail.bookswithretrofit.MainActivityFeature.MainActivityModule;
import com.ismail.bookswithretrofit.adapter.BookAdapter;
import com.ismail.bookswithretrofit.application.BookApplication;
import com.ismail.bookswithretrofit.model.BasicRepsonse;
import com.ismail.bookswithretrofit.interfaces.BooksApi;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;

    Picasso picasso;

    @Inject
    BooksApi booksApi;

    @Inject
    BookAdapter mAdapter;

    private BookAdapter adapter;

    private RecyclerView recyclerView;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        populateUsers();
        afterActivityLevelComponent();

    }


    private void afterActivityLevelComponent() {
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .bookComponent(BookApplication.get(this).getBookApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);
////
//        MainActivityComponent mainActivityComponent = DaggerAppComponent.builder()
//                .appModule(new MainActivityModule(this))
//                .build();
//        mainActivityComponent.injectMainActivity(this);
    }

    private void populateUsers() {

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Loading....");
        mProgressDialog.show();


        Call<BasicRepsonse> bookCall = getBooksService().getAllBooks();
        bookCall.enqueue(new Callback<BasicRepsonse>() {
            @Override
            public void onResponse(Call<BasicRepsonse> call, @NonNull Response<BasicRepsonse> response) {
                if(response.isSuccessful()) {
                    mAdapter.setItems(response.body().getItems());
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<BasicRepsonse> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });


//        /*Create handle for the RetrofitInstance interface*/
//        BooksApi service = RetrofitClientInstance.getRetrofitInstance().create(BooksApi.class);
//        Call<BasicRepsonse> call = service.getAllBooks();
//        call.enqueue(new Callback<BasicRepsonse>() {
//            @Override
//            public void onResponse(Call<BasicRepsonse> call, Response<BasicRepsonse> response) {
//                mProgressDialog.dismiss();
//                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
//                generateDataList(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<BasicRepsonse> call, Throwable t) {
//                mProgressDialog.dismiss();
//                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.customRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public BooksApi getBooksService(){
        return booksApi;
    }

}