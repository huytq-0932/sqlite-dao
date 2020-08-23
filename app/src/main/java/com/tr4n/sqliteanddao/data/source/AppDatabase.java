package com.tr4n.sqliteanddao.data.source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tr4n.sqliteanddao.data.model.Student;

public class AppDatabase extends SQLiteOpenHelper {

    private static final String NAME = "students.db";
    private static final int VERSION = 1;

    private static final String SQL_CREATE_TABLE_STUDENT = "CREATE TABLE IF NOT EXISTS " + Student.TABLE_NAME + "(" +
            Student.ID + " INTEGER PRIMARY KEY, " +
            Student.NAME + " TEXT, " +
            Student.CLASS_NAME + " TEXT)";
    private static final String SQL_DROP_TABLE_STUDENT = "DROP TABLE IF EXISTS " + Student.TABLE_NAME;

    private static AppDatabase instance;

    private AppDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context, NAME, null, VERSION);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE_STUDENT);
        onCreate(sqLiteDatabase);
    }
}
