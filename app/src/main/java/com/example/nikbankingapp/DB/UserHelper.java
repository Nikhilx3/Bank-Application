package com.example.nikbankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nikbankingapp.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 1;
    String TABLE_NAME = UserEntry.TABLE_NAME;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL("insert into " + TABLE_NAME + " values(1500000,'Nikhil Maurya', 'nikhil@gmail.com','7584',00001, 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1344,'Palash Jain', 'Palash @gmail.com','1258','00002', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(78885,'Lakhan Amley', 'Lakhan@gmail.com','8896','00003', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7777668,'Abhay Pratap Singh', 'AbhayPratapSingh@gmail.com','7752','00004', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(788770,'Vishal kumar', 'Vishalkumar@gmail.com','3669','00005', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8774983,'Vivek', 'Vivek@gmail.com','9985',00006, 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0990938,'Anchal', 'Anchal@gmail.com','1207','00007', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(99999999,'Deepti', 'Deepti@gmail.com','4522','00008', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8844,'Rahul', 'Rahul@gmail.com','6582','00009', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(298845,'Sachin', 'Sachin@gmail.com','5450','00010', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(97949,'abhishek', 'abhishek@gmail.com','2656',00011, 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(476738,'Aman', 'Aman@gmail.com','1203','00012', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(76542,'Meet', 'Meet@gmail.com','5566','00013', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(889872,'Umesh', 'Umesh@gmail.com','2236','00014', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(999990,'Lalit', 'Lalit@gmail.com','6692','00015', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}