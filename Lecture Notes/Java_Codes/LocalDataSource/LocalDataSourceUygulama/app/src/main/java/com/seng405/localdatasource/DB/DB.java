package com.seng405.localdatasource.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.seng405.localdatasource.Entity.Contact;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private final static String databaseName = "ContactsDB";
    private final static int databaseVersion = 1;
    private String CONTACT_TABLE = "Contacts";
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
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + CONTACT_TABLE + " ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT,"
                + " phoneNumber TEXT,"
                + " email TEXT"
                + " )";

        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void addNewContact(String name,String phone,String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("phoneNumber",phone);
        contentValues.put("email",email);


        sqLiteDatabase.insert(CONTACT_TABLE,null,contentValues);

        sqLiteDatabase.close();

    }

    public ArrayList<Contact> getAllContacts()
    {
        ArrayList<Contact> contactsArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(CONTACT_TABLE,null,null,null,null,null,null);

        if(cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));

                Contact contact = new Contact(id,name,phone,email);

                contactsArrayList.add(contact);



            }
            while(cursor.moveToNext());
        }


        return contactsArrayList;
    }

    public void deleteContact(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(CONTACT_TABLE,"id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public void updateContact(int id, String name, String phone, String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phoneNumber",phone);
        contentValues.put("email",email);

        sqLiteDatabase.update(CONTACT_TABLE,contentValues,"id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public Contact getContact(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(CONTACT_TABLE,null,"id= ? " ,new String[]{ String.valueOf(id) },null,null,null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + CONTACT_TABLE + " WHERE id = " + id,null);

        Contact contact = null;

        if(cursor.moveToFirst())
        {
            do {
                int userId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));

                contact = new Contact(userId,name,phone,email);

            }
            while(cursor.moveToNext());
        }

        return contact;
    }


}
