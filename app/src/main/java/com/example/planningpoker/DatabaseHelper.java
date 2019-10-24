package com.example.planningpoker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "voters_db";
    private static final String DATABASE_NAME2 = "users_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Voter.CREATE_TABLE);
    }

    public void onCreate1(SQLiteDatabase db) {
        db.execSQL(User.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Voter.TABLE_NAME);
        onCreate(db);
    }

    public long insertVoter(String name,String question,String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Voter.COLUMN_NAME, name);
        values.put(Voter.COLUMN_QUESTION, question);
        values.put(Voter.COLUMN_ANSWER, answer);
        long id = db.insert(Voter.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public long insertUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Voter.COLUMN_NAME, name);
        long id = db.insert(Voter.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Voter getVoter(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Voter.TABLE_NAME,
                new String[]{Voter.COLUMN_ID, Voter.COLUMN_NAME,Voter.COLUMN_QUESTION,Voter.COLUMN_ANSWER},
                Voter.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Voter voter = new Voter(
                cursor.getInt(cursor.getColumnIndex(Voter.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Voter.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Voter.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(Voter.COLUMN_ANSWER))
        );
        cursor.close();
        return voter;
    }

    public List<Voter> getAllVoter() {
        List<Voter> voters = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Voter.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Voter voter = new Voter();
                voter.setId(cursor.getInt(cursor.getColumnIndex(Voter.COLUMN_ID)));
                voter.setName(cursor.getString(cursor.getColumnIndex(Voter.COLUMN_NAME)));
                voter.setQuestion(cursor.getString(cursor.getColumnIndex(Voter.COLUMN_QUESTION)));
                voter.setAnswer(cursor.getString(cursor.getColumnIndex(Voter.COLUMN_ANSWER)));
                voters.add(voter);
            } while (cursor.moveToNext());
        }
        db.close();
        return voters;
    }

    public User getUser(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(User.TABLE_NAME,
                new String[]{User.COLUMN_ID, User.COLUMN_NAME},
                User.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        User user = new User(
                cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(User.COLUMN_NAME))
        );
        cursor.close();
        return user;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + User.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(User.COLUMN_NAME)));
                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return users;
    }


}