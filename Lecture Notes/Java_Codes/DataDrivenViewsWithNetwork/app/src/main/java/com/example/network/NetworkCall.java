package com.example.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkCall {

    public NetworkCall(){}


    //https://api.coingecko.com/api/v3/coins/list Coin isim listesini alacağımız url
    //https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin,ethereum Coin bilgilerini alacağımız url

    public void getCoinList(View view){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin,ethereum,01coin,0chain,0vix-protocol,0x,0x0-ai-ai-smart-contract,0xdao,0xdao-v2,0xmonero,0xwallet-token,12405-santa-rosa,12ships,1337,14066-santa-rosa,1617-s-avers,1art,1bch,1box")
                .method("GET", null)
                .addHeader("accept", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("Hatalı işlem", "onFailure:");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if(response.isSuccessful())
                {
                    final String json = response.body().string();
                    Coin[] CoinList = new Gson().fromJson(json, Coin[].class);

                    view.displayCoinData(CoinList);

                }
            }
        });
    }


}
