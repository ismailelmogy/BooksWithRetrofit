package com.ismail.bookswithretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ismail.bookswithretrofit.MainActivity;
import com.ismail.bookswithretrofit.R;
import com.ismail.bookswithretrofit.model.BasicRepsonse;
import com.ismail.bookswithretrofit.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final Picasso picasso;
    private List<Item> resultList = new ArrayList<>();


    public BookAdapter(MainActivity mainActivity , Picasso picasso){
      this.picasso = picasso;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new BookViewHolder(view);
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle,txtDescription;
        ImageView imageView;

        BookViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtTitle = mView.findViewById(R.id.title);
            txtDescription = mView.findViewById(R.id.description);
            imageView = mView.findViewById(R.id.image);
        }
    }


    public void setItems(List<Item> results) {
        resultList = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {

        Item result = resultList.get(position);

            holder.txtTitle.setText(result.getVolumeInfos().
                    getTitle());
            holder.txtDescription.setText(result.getVolumeInfos().
                    getDescription());
        picasso.with(holder.imageView.getContext())
                .load(result.getVolumeInfos().getImageLinks().getThumbnail())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}
