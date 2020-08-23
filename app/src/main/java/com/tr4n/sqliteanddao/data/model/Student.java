package com.tr4n.sqliteanddao.data.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Student {
    public static final String TABLE_NAME = "Student";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CLASS_NAME = "className";

    private int id;
    private String name;
    private String className;

    public Student(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public Student(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(ID));
        this.name = cursor.getString(cursor.getColumnIndex(NAME));
        this.className = cursor.getString(cursor.getColumnIndex(CLASS_NAME));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, this.id);
        contentValues.put(NAME, this.name);
        contentValues.put(CLASS_NAME, this.className);
        return contentValues;
    }

}
