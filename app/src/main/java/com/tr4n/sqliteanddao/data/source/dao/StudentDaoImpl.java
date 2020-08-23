package com.tr4n.sqliteanddao.data.source.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tr4n.sqliteanddao.data.model.Student;
import com.tr4n.sqliteanddao.data.source.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SQLiteDatabase writeableDb;
    private SQLiteDatabase readableDb;

    public StudentDaoImpl(SQLiteOpenHelper database) {
        this.writeableDb = database.getWritableDatabase();
        this.readableDb = database.getReadableDatabase();
    }

    @Override
    public List<Student> getAll() {
        //readableDb.rawQuery("SELECT * FROM " + Student.TABLE_NAME , null);
        Cursor cursor = readableDb.query(Student.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();

        List<Student> students = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Student student = new Student(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    @Override
    public void create(Student student) {
        writeableDb.insert(Student.TABLE_NAME, null, student.getContentValues());
    }
}
