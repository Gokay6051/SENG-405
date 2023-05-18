package com.example.a202011057_seng405_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText string;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        string = (EditText)findViewById(R.id.editText);
    }

    public void buttonStart(View v){
        s1 = string.getText().toString();

        if(!TextUtils.isEmpty(s1)){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("string", s1);
                startActivity(intent);
        }
    }
}