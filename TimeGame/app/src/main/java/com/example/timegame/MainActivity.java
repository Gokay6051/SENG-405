package com.example.timegame;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.timegame.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText player1, player2;
    private TextView txtIsEmpty;
    //player1 = p1, player2 = p2
    private String p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = (EditText)findViewById(R.id.editTextPlayerName);
        player2 = (EditText)findViewById(R.id.editTextPlayerName2);
        txtIsEmpty = (TextView)findViewById(R.id.textViewError);
    }

    public void buttonStart(View v){
        p1 = player1.getText().toString();
        p2 = player2.getText().toString();

        if(!TextUtils.isEmpty(p1)){
            if(!TextUtils.isEmpty(p2)){
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("player1", p1);
                intent.putExtra("player2", p2);
                startActivity(intent);
            }
        }
        txtIsEmpty.setText("Spaces cannot be left blank!");
    }

}