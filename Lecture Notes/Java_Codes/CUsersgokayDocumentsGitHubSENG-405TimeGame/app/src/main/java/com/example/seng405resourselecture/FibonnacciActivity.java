package com.example.seng405resourselecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FibonnacciActivity extends AppCompatActivity {

    EditText editTextNumber;
    TextView outputText;
    Button calculate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonnacci);

        editTextNumber = findViewById(R.id.editTextNumber);
        outputText = findViewById(R.id.outputText);
        calculate_btn = findViewById(R.id.calculate_btn);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateFibonacciHandler();

            }
        });
    }

    private void calculateFibonacciHandler()
    {
        String editTextString = editTextNumber.getText().toString();
        int editTextInt = Integer.parseInt(editTextString);
        String fibonacciResultString = calculateFibonacci(editTextInt);
        outputText.setText(fibonacciResultString);
    }

    private String calculateFibonacci(int n){

        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        // Display the Fibonacci sequence in the TextView
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(fib[i]).append(", ");
        }

        return sb.toString();

    }

}