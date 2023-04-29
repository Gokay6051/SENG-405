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
        if(haveNetworkConnection())
        {
            getCoinData();
        }
        else
        {
            Toast.makeText(getApplicationContext(), R.string.network_connection_error, Toast.LENGTH_SHORT);
        }

    }

    private void getCoinData(){
        NetworkCall networkCall = new NetworkCall();
        networkCall.getCoinList(this);
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    @Override
    public void displayCoinData(Coin[] coins) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                displayCoinList(coins);
            }
        });
    }

    private void displayCoinList(Coin[] coins) {
        ArrayList<Coin> coinArrayList = new ArrayList<Coin>();

        Collections.addAll(coinArrayList, coins);

        RecyclerView recyclerView = findViewById(R.id.coinsRecyclerView);

        CoinAdapter coinAdapter = new CoinAdapter(coinArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(coinAdapter);
    }
}