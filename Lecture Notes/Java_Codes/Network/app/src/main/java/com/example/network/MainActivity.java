package com.example.network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCoinData();


    }

    private void getCoinData(){
        NetworkCall networkCall = new NetworkCall();
        networkCall.getCoinList(this);
    }


    @Override
    public void displayCoinData(Coin[] coins) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //UI işlemleri burada yapılır
            }
        });
    }

}