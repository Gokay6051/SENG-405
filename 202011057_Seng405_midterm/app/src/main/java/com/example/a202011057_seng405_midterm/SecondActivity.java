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
            Toast.makeText(getApplicationContext(), "network_connection_error", Toast.LENGTH_SHORT).show();
        }
    }
    private void getPersonData() {
        NetworkCall networkCall = new NetworkCall(S1);
        networkCall.getPersonList(this);
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for(NetworkInfo networkInfo : networkInfos)
        {
            if(networkInfo.getTypeName().equalsIgnoreCase("WIFI"))
            {
                if(networkInfo.isConnected())
                {
                    haveConnectedWifi = true;
                }
            }
            if(networkInfo.getTypeName().equalsIgnoreCase("MOBILE"))
            {
                if(networkInfo.isConnected())
                {
                    haveConnectedMobile = true;
                }
            }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    @Override
    public void displayPersonData(Person[] persons) {
        SecondActivity.this.runOnUiThread(() -> displayPersonList(persons));
    }

    private void displayPersonList(Person[] persons) {
        ArrayList<Person> personArrayList = new ArrayList<>();

        Collections.addAll(personArrayList, persons);

        RecyclerView recyclerView = findViewById(R.id.personsRecyclerView);

        PersonAdapter personAdapter = new PersonAdapter(personArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(personAdapter);
    }
}