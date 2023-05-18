package com.example.a202011057_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText metin;
    private TextView errorText;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metin = (EditText)findViewById(R.id.editTextMetin);
        errorText = (TextView)findViewById(R.id.textViewError);
    }

    public void buttonShow(View v){
        /*
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("Geo:47.4925,19.0513"));
        Intent chooser = Intent.createChooser(intent, "Lauch Maps");
        startActivity(chooser);

         */

        s1 = metin.getText().toString();

        if(!TextUtils.isEmpty(s1)){
            errorText.setText(" ");
            Intent intent = new Intent(MainActivity.this, GosterActivity.class);
            intent.putExtra("metin", s1);
            startActivity(intent);
        }else 
            errorText.setText("Metin kısmı boş bırakılamaz.");

    }
}