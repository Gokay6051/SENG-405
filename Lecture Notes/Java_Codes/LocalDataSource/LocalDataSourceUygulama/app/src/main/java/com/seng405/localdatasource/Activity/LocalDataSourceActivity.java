package com.seng405.localdatasource.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.seng405.localdatasource.R;

public class LocalDataSourceActivity extends Activity {

    private Button getInt_btn,setInt_btn,setString_btn,getString_btn;

    private EditText editTextString,editTextInt;

    private TextView textViewInt,textViewString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInt_btn = findViewById(R.id.getInt_btn);
        setInt_btn = findViewById(R.id.setInt_btn);
        setString_btn = findViewById(R.id.setString_btn);
        getString_btn = findViewById(R.id.getString_btn);

        editTextString = findViewById(R.id.editTextString);
        editTextInt = findViewById(R.id.editTextInt);

        textViewInt = findViewById(R.id.textViewInt);
        textViewString = findViewById(R.id.textViewString);

        setString_btn.setOnClickListener(v -> {
            writeStringDataToSharedPreferences(editTextString.getText().toString());
        });

        getString_btn.setOnClickListener(v -> {
            textViewString.setText(readStringDataFromSharedPreferences());
        });

        setInt_btn.setOnClickListener(v -> {
            writeIntDataToSharedPreferences(Integer.parseInt(editTextInt.getText().toString()));
        });

        getInt_btn.setOnClickListener(v -> {
            textViewInt.setText(String.valueOf(readIntDataFromSharedPreferences()));
        });

    }

    private void writeStringDataToSharedPreferences(String data){
        SharedPreferences preferences = this.getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("LANGUAGE",String.valueOf(data));
        editor.apply();

    }

    private String readStringDataFromSharedPreferences()
    {
        SharedPreferences preferences = this.getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE);
        String result = preferences.getString("LANGUAGE", "");
        return result;
    }

    private void writeIntDataToSharedPreferences(int data){
        SharedPreferences preferences = this.getSharedPreferences("IntData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("IntData",data);
        editor.apply();
    }

    private int readIntDataFromSharedPreferences()
    {
        SharedPreferences preferences = this.getSharedPreferences("IntData", Context.MODE_PRIVATE);
        int result = preferences.getInt("IntData", 0);
        return result;
    }




}