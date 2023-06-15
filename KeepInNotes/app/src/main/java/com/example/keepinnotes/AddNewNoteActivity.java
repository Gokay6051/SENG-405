package com.example.keepinnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.keepinnotes.DB.DB;

public class AddNewNoteActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription;
    private Button addNewNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        editTextTitle = findViewById(R.id.displayEditTextTitle);
        editTextDescription = findViewById(R.id.displayEditTextDescription);
        addNewNoteButton = findViewById(R.id.displayAddNoteButton);

        addNewNoteButton.setOnClickListener(v -> {
            addNewNote();
        });
    }

    private void addNewNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

        DB.getInstance(this).addNewNote(title, description);

        finish();
    }
}