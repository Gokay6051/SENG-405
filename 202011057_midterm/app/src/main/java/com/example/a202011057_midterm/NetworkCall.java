package com.example.a202011057_midterm;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkCall {
    public NetworkCall(){}

    public void getUserList(View view){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .method("GET", null)
                .build();
        //Response response = client.newCall(request).execute();

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
                    User[] UserList = new Gson().fromJson(json, User[].class);

                    view.displayUserData(UserList);

                }
            }
        });

    }
}
