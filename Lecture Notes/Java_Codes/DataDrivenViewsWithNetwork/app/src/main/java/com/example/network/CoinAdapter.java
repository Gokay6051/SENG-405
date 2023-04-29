package com.example.network;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {
    private ArrayList<Coin> coinItemList;


    public CoinAdapter( ArrayList<Coin> coinItemList) {
        this.coinItemList = coinItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.coin_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Coin coin = coinItemList.get(position);
        holder.coinNameTextView.setText(coin.getName());
        if(coin.getCurrentPrice() != null) {
            holder.coinPriceTextView.setText(coin.getCurrentPrice().toString());
        }

        if(coin.getImage() != null) {
            Glide.with(holder.imageView.getContext())
                    .load(coin.getImage())
                    .placeholder(R.drawable.image_place_holder)
                    .error(R.drawable.image_error)
                    .override(200, 200)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return coinItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView coinNameTextView;
        private TextView coinPriceTextView;
        private ImageView imageView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            coinNameTextView = itemView.findViewById(R.id.coinNameTextView);
            coinPriceTextView = itemView.findViewById(R.id.coinPriceTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
