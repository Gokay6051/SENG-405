package com.example.datadrivenview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView userList = (ListView) findViewById(R.id.userList);

        ArrayList<String> userListArrayList = new ArrayList<String>();
        userListArrayList.add("John");
        userListArrayList.add("Jane");
        userListArrayList.add("Jack");
        userListArrayList.add("Jill");


        ArrayAdapter<String> userListAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, userListArrayList);

        userList.setAdapter(userListAdapter);






    }
}