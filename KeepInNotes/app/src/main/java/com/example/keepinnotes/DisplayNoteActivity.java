package com.example.keepinnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.keepinnotes.DB.DB;
import com.example.keepinnotes.entity.Note;

public class DisplayNoteActivity extends AppCompatActivity {
    private int id;
    private EditText displayEditTextTitle, displayEditTextDescription;
    private Button displayAddNoteButton, displayDeleteNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_note);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        displayEditTextTitle = findViewById(R.id.displayEditTextTitle);
        displayEditTextDescription = findViewById(R.id.displayEditTextDescription);
        displayAddNoteButton = findViewById(R.id.displayAddNoteButton);
        displayDeleteNoteButton = findViewById(R.id.displayDeleteNoteButton);

        displayAddNoteButton.setOnClickListener(v -> {
            saveNote();
        });

        displayDeleteNoteButton.setOnClickListener(v -> {
            deleteNote();
        });

        Note note = DB.getInstance(this).getNote(id);

        displayEditTextTitle.setText(note.getTitle());
        displayEditTextDescription.setText(note.getDescription());
    }


    private void saveNote() {
        String title = displayEditTextTitle.getText().toString();
        String description = displayEditTextDescription.getText().toString();

        DB.getInstance(this).updateNote(id, title, description);

        finish();
    }

    private void deleteNote() {
        DB.getInstance(this).deleteNote(id);
        finish();
    }
}