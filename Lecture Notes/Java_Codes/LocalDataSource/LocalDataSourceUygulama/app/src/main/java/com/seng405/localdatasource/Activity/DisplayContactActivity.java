package com.seng405.localdatasource.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.seng405.localdatasource.DB.DB;
import com.seng405.localdatasource.Entity.Contact;
import com.seng405.localdatasource.R;

public class DisplayContactActivity extends AppCompatActivity {

    private int id;

    private EditText editTextTextPersonName,editTextPhone,editTextTextEmailAddress;
    private Button updateButton,deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);

        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        updateButton.setOnClickListener(v -> {
            updateContact();
        });

        deleteButton.setOnClickListener(v -> {
            deleteContact();
        });

        Contact contact = DB.getInstance(this).getContact(id);

        editTextTextPersonName.setText(contact.getName());
        editTextPhone.setText(contact.getPhoneNumber());
        editTextTextEmailAddress.setText(contact.getEmail());


    }

    private void updateContact() {
        String name = editTextTextPersonName.getText().toString();
        String phone = editTextPhone.getText().toString();
        String email = editTextTextEmailAddress.getText().toString();

        DB.getInstance(this).updateContact(id,name,phone,email);

        finish();


    }


    private void deleteContact() {

        DB.getInstance(this).deleteContact(id);
        finish();
    }


}