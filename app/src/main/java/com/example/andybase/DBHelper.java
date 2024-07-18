package com.example.andybase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String databaseName = "Signup.db";
    public DBHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table allusers(id integer primary key autoincrement ,fname text,lname text,email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  Boolean insertData(String fname,String lname,String email,String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fname",fname);
        cv.put("lname",lname);
        cv.put("email",email);
        cv.put("password",pass);
        long res = db.insert("allusers",null,cv);
        if(res != -1)
            return true;
        else
            return false;
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from allusers where email = ?",new String[]{email});
        if(c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkemailpass(String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from allusers where email = ? and password = ?",new String[]{email,pass});
        if(c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean updatepassword(String username1, String retype1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("password",retype1);
        long res = db.update("allusers",cv,"email = ?",new String[]{username1});
        if(res != -1)
            return true;
        else
            return false;
    }

    public Cursor showdata(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("Select * from allusers where email = ?",new String[]{email});
    }

    public Boolean updateemail(String em, String uem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email",em);
        long res = db.update("allusers",cv,"email = ?",new String[]{uem});
        if(res != -1)
            return true;
        else
            return false;
    }
}
