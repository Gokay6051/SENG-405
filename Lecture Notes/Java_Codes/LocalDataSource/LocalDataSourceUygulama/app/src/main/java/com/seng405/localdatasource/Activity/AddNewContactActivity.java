package com.seng405.localdatasource.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.seng405.localdatasource.DB.DB;
import com.seng405.localdatasource.R;

public class AddNewContactActivity extends AppCompatActivity {

    private EditText editTextTextPersonName,editTextPhone,editTextTextEmailAddress;
    private Button addNewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);


        addNewButton = findViewById(R.id.addNewButton);

        addNewButton.setOnClickListener(v -> {
            addNewContact();
        });


    }

    private void addNewContact() {
        String name = editTextTextPersonName.getText().toString();
        String phone = editTextPhone.getText().toString();
        String email = editTextTextEmailAddress.getText().toString();

        DB.getInstance(this).addNewContact(name,phone,email);

        finish();


    }
}