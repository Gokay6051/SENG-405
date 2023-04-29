package com.example.datadrivenview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private ArrayList<Coin> coinItemList;

    public CoinAdapter(ArrayList<Coin> coinItemList) {
        this.coinItemList = coinItemList;
    }


    @NonNull
    @Override
    public CoinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_one_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinAdapter.ViewHolder holder, int position) {
        Coin coin = coinItemList.get(position);
        holder.coinNameTextView.setText(coin.getName());
        holder.coinPriceTextView.setText(coin.getCurrentPrice().toString());


        if(coin.getImage() != null) {
        Glide.with(holder.imageView.getContext())
                    .load(coin.getImage())
//                    .placeholder(R.drawable.image_place_holder)
//                    .error(R.drawable.image_error)
                    .into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return coinItemList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView coinNameTextView;
        private TextView coinPriceTextView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            coinNameTextView = itemView.findViewById(R.id.coinNameTextView);
            coinPriceTextView = itemView.findViewById(R.id.coinPriceTextView);

        }
    }
}
