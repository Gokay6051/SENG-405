package com.example.a202011057_midterm;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GosterActivity extends AppCompatActivity implements View{
    private String S1;
    private TextView metin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster);

        metin = (TextView)findViewById(R.id.textViewGoster);

        Intent incomingIntent = getIntent();
        S1 = incomingIntent.getStringExtra("metin");
        metin.setText(S1);

        if(haveNetworkConnection())
        {
            try {
                getUsersData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "network_connection_error", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUsersData() throws IOException {
        NetworkCall networkCall = new NetworkCall();
        networkCall.getUserList(this);
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

    public void displayUserData(User[] users) {
        GosterActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                displayUserList(users);
            }
        });
    }

    private void displayUserList(User[] users) {
        ArrayList<User> userArrayList = new ArrayList<User>();

        Collections.addAll(userArrayList, users);

        RecyclerView recyclerView = findViewById(R.id.usersRecyclerView);

        UserAdapter userAdapter = new UserAdapter(userArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(userAdapter);
    }
}