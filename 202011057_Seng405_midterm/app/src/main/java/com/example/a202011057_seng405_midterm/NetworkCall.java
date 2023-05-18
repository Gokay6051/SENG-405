package com.example.a202011057_seng405_midterm;

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
    //private String S;
    public NetworkCall(){}

    public void getPersonList(View view) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://reqres.in/api/users?page=2")
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
                    Person[] PersonList = new Gson().fromJson(json, Person[].class);

                    view.displayPersonData(PersonList);

                }
            }
        });
    }
}
