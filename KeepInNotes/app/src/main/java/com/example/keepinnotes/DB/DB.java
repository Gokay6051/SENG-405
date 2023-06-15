package com.example.keepinnotes.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.keepinnotes.entity.Note;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private final static String databaseName = "NotesDB";

    private final static int databaseVersion = 1;

    private String NOTE_TABLE = "Notes";

    private static DB dbInstance = null;



    public synchronized static DB getInstance(Context context)
    {
        if(dbInstance == null)
        {
            dbInstance = new DB(context.getApplicationContext());
        }
        return dbInstance;
    }
    public DB(Context context)
    {
        super(context,databaseName,null,databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + NOTE_TABLE + " ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " title TEXT,"
                + " description TEXT"
                + " )";

        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNewNote(String title,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("title",title);
        contentValues.put("description",description);

        db.insert(NOTE_TABLE,null,contentValues);
    }

    public ArrayList<Note> getAllNotes()
    {
        ArrayList<Note> notes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + NOTE_TABLE;

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst())
        {
            do{
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

                Note note = new Note(id,title,description);

                notes.add(note);
            }while (cursor.moveToNext());
        }
        db.close(); // BURAYA BİR DAHA BAK
        return notes;
    }

    public void deleteNote(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(NOTE_TABLE,"id = ?",new String[]{String.valueOf(id)});
        db.close();
    }

    public void updateNote (int id, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);

        db.update(NOTE_TABLE, contentValues, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Note getNote(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + NOTE_TABLE + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery,null);

        Note note = null;

        if(cursor.moveToFirst())
        {
            do {
                int noteId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

                note = new Note (noteId,title,description);
            }
            while (cursor.moveToNext());
        }
        db.close(); // BURAYA BİR DAHA BAK
        return note;
    }
}
