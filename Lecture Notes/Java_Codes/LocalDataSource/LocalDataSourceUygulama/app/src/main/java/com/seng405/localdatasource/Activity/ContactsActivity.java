package com.seng405.localdatasource.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.seng405.localdatasource.Adapters.ContactAdapter;
import com.seng405.localdatasource.DB.DB;
import com.seng405.localdatasource.Entity.Contact;
import com.seng405.localdatasource.R;

import java.util.ArrayList;

public class ContactsActivity extends Activity {

    private RecyclerView contactsRecyclerView;
    private Button addNewContactButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);
        addNewContactButton = findViewById(R.id.addNewContactButton);

        addNewContactButton.setOnClickListener(v -> {
            navigateToAddContactActivity();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Contact> contacts = DB.getInstance(this).getAllContacts();
        displayContacts(contacts);
    }

    private void navigateToAddContactActivity(){
        Intent intent = new Intent(this,AddNewContactActivity.class);
        startActivity(intent);
    }

    private void displayContacts(ArrayList<Contact> contacts){

        ContactAdapter contactAdapter = new ContactAdapter(contacts, item -> {
            Intent intent = new Intent(this,DisplayContactActivity.class);
            intent.putExtra("id",item.getId());
            startActivity(intent);
        } );


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        contactsRecyclerView.setLayoutManager(layoutManager);
        contactsRecyclerView.setAdapter(contactAdapter);
    }


}