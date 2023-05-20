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
    String s1;
    public NetworkCall(String s1){this.s1=s1;}

    public void getPersonList(View view) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");


        Request request = new Request.Builder()
                .url("https://reqres.in/api/users?page=" + s1)
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
                    assert response.body() != null;
                    final String json = response.body().string();
                    Data data = new Gson().fromJson(json, Data.class);
                    Person[] personList = data.getPersons();
                    view.displayPersonData(personList);

                }
            }
        });
    }
}
