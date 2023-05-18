package com.example.a202011057_seng405_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity implements View{
    private String S1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent incomingIntent = getIntent();
        S1 = incomingIntent.getStringExtra("string");

        if(haveNetworkConnection())
        {
                getPersonData();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "network_connection_error", Toast.LENGTH_SHORT);
        }
    }
    private void getPersonData() {
        NetworkCall networkCall = new NetworkCall();
        networkCall.getPersonList(this); //tekrar bak
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
    public void displayPersonData(Person[] persons) {
        SecondActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                displayPersonList(persons);
            }
        });
    }

    private void displayPersonList(Person[] persons) {
        ArrayList<Person> personArrayList = new ArrayList<Person>();

        Collections.addAll(personArrayList, persons);

        RecyclerView recyclerView = findViewById(R.id.personsRecyclerView);

        PersonAdapter personAdapter = new PersonAdapter(personArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(personAdapter);
    }
}