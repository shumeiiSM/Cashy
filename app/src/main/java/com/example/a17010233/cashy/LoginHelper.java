package com.example.a17010233.cashy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class LoginHelper extends SQLiteOpenHelper {
    //TODO Define the Database properties
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "login.db";
    private static final String TABLE_ACC = "account";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NUM = "number";
    private static final String COLUMN_PASS = "pass";

    public LoginHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO CREATE TABLE Note
        String createTableSql = "CREATE TABLE " + TABLE_ACC + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_NUM + " INTEGER,"
                + COLUMN_PASS + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACC);
        onCreate(db);
    }

    public long insertAccount(String name, int number, String pass) {
        //TODO insert the data into the database
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_NAME, name);
        // Store the column name as key and the date as value
        values.put(COLUMN_NUM, number);
        // Store the column name as key and the date as value
        values.put(COLUMN_PASS, pass);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_ACC, null, values);

        long result = db.insert(TABLE_ACC, null, values);
        // Close the database connection
        db.close();
        if (result == -1){
            Log.d("DBHelper", "Insert failed");
        } else {
            Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
        }

        return result;
    }

    public int updateAcc(Account data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASS, data.getPass());

        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};

        int result = db.update(TABLE_ACC, values, condition, args);
        if (result < 1){
            Log.d("DBHelper", "Update failed");
        }

        db.close();
        return result;
    }


    public ArrayList<Account> getAllAccount() {
        //TODO return records in Java objects
        ArrayList<Account> accounts = new ArrayList<Account>();
        // Select all the friends' content
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_NAME + ", "
                + COLUMN_NUM + ", "
                + COLUMN_PASS
                + " FROM " + TABLE_ACC;
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row and returns true;
            // moveToNext() returns false when no more next row to move to
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int number = cursor.getInt(2);
                String pass = cursor.getString(3);
                Account obj = new Account(id, name, number, pass);
                accounts.add(obj);
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return accounts;
    }

    public ArrayList<String> getName() {
        //TODO return records in Strings
        // Create an ArrayList that holds String objects
        ArrayList<String> accounts = new ArrayList<String>();
        // Select all the notes' description
        String selectQuery = "SELECT " + COLUMN_NAME + COLUMN_PASS
                + " FROM " + TABLE_ACC;
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  0 in getString(0) return the data in the first
                //  column in the Cursor object. getString(1)
                //  return second column data and so on.
                //  Use getInt(0) if data is an int
                accounts.add(cursor.getString(0));
                accounts.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();
        return accounts;
    }
}

