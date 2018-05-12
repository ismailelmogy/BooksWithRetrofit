package com.ismail.bookswithretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ismail.bookswithretrofit.R;
import com.ismail.bookswithretrofit.model.Item;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private List<Item> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Item> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle,txtDescription;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            txtDescription = mView.findViewById(R.id.description);


        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {



//            VolumeInfo volumeInfo = items.get(i).getVolumeInfos();
            holder.txtTitle.setText(dataList.get(position).getVolumeInfos().
                    getTitle());
            holder.txtDescription.setText(dataList.get(position).getVolumeInfos().
                    getDescription());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
