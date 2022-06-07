package com.example.practicals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLAdapter extends SQLiteOpenHelper {
    public SQLAdapter(Context context){
        super(context, "Practicals.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE User" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT," + "DESCRIPTION TEXT," + "FOLLOWED TEXT)";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);

    }

    public ArrayList<User> getUsers(){
        String query = "SELECT * FROM User";
        ArrayList<User> newUserList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            newUserList.add(new User(cursor.getString(1), cursor.getString(2),
                    cursor.getInt(0), Boolean.parseBoolean(cursor.getString(3))));
        }
        return newUserList;
    }

    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put("ID", user.id);
        values.put("NAME", user.name);
        values.put("DESCRIPTION", user.description);
        values.put("FOLLOWED", user.followed);
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("User", null, values);
    }

    public void updateUser(User user){
        int id = user.id;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String followStatus = (user.followed == true) ? "Followed" : "Unfollow";
        values.put("FOLLOWED", followStatus);
        db.update("User", values, "ID=?", new String[]{String.valueOf(id)});
    }
    public void insertMessage(String hello_world) {
    }
}
