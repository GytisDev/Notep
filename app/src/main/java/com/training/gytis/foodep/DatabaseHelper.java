package com.training.gytis.foodep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Gytis on 2017-09-14.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    private static final String TABLE_NAME = "notes_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "NOTE";
    private static final String COL_4 = "DATE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT " + ");");
        Log.w("MyApp", "Pasiekta on create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNote(Note note){
        ContentValues values = new ContentValues();
        values.put(COL_2, note.getName());
        values.put(COL_3, note.getNote());
        values.put(COL_4, note.getDate());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        Log.d("MyApp", "Pasiekta addFood");
        db.close();
    }

    public void deleteNote(Note note){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COL_2 + "=\""+ note.getName() + "\" AND " + COL_3 + "=\""+ note.getNote() + "\" AND " + COL_4 + "=\"" + note.getDate() + "\"");
    }

    public void updateNote(Note oldNote, Note newNote){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(COL_2, newNote.getName());
        data.put(COL_3, newNote.getNote());
        data.put(COL_4, newNote.getDate());
        db.update(TABLE_NAME, data, COL_2 + "=\""+ oldNote.getName() + "\" AND " + COL_3 + "=\""+ oldNote.getNote() + "\" AND " + COL_4 + "=\"" + oldNote.getDate() + "\"", null);
    }

    public String databaseToString(){
        Log.d("MyApp", "Pasiekta toString");
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("NAME")) != null){
                Log.d("MyApp", "Pasiekta ciklo vidus");
                dbString += c.getString(c.getColumnIndex("NAME"));
                dbString += ",";
            }

            c.moveToNext();
        }


        db.close();
        return dbString;

    }

    public ArrayList<Note> databaseToList(){
        ArrayList<Note> notes = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("NAME")) != null){

                String name = c.getString(c.getColumnIndex("NAME"));
                String note = c.getString(c.getColumnIndex("NOTE"));
                String date = c.getString(c.getColumnIndex("DATE"));

                notes.add(new Note(name, note, date));

            }

            c.moveToNext();
        }

        Log.w("MyApp", "Pasiekta po ciklo");

        db.close();
        return notes;
    }
}
