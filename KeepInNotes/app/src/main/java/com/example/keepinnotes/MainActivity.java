package com.example.keepinnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.keepinnotes.DB.DB;
import com.example.keepinnotes.entity.Note;

import java.util.ArrayList;

import com.example.keepinnotes.adapters.NoteAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;
    private Button addNewNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        addNewNoteButton = findViewById(R.id.addNewNoteButton);

        addNewNoteButton.setOnClickListener(v -> {
            navigateToAddNoteActivity();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Note> notes = DB.getInstance(this).getAllNotes();
        displayNotes(notes);
    }

    private void navigateToAddNoteActivity() {
        Intent intent = new Intent(this, AddNewNoteActivity.class);
        startActivity(intent);
    }

    private void displayNotes(ArrayList<Note> notes) {
        NoteAdapter noteAdapter = new NoteAdapter(notes, item -> {
            Intent intent = new Intent(this, DisplayNoteActivity.class);
            intent.putExtra("id", item.getId());
            startActivity(intent);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(layoutManager);
        notesRecyclerView.setAdapter(noteAdapter);
    }

}