package com.techsuzu.selectcountrydemoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.techsuzu.select_country.Data;

import java.util.List;

class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Data> dataList;
    private OnItemSelectListner onItemSelectListner;

    CountryAdapter(List<Data> dataList, OnItemSelectListner listner) {
        this.dataList = dataList;
        this.onItemSelectListner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_list_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Data data = dataList.get(i);
        viewHolder.flag.setImageBitmap(data.getFlag());
        viewHolder.country.setText(data.getCountry());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnItemSelectListner {
        void itemSelect(Data data);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView flag;
        TextView country;
        LinearLayout item;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            country = itemView.findViewById(R.id.country);
            item = itemView.findViewById(R.id.item);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item:
                    onItemSelectListner.itemSelect(dataList.get(getAdapterPosition()));
                    break;
            }
        }
    }
}
