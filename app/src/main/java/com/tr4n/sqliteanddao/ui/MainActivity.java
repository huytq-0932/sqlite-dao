package com.tr4n.sqliteanddao.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tr4n.sqliteanddao.R;
import com.tr4n.sqliteanddao.data.model.Student;
import com.tr4n.sqliteanddao.data.source.AppDatabase;
import com.tr4n.sqliteanddao.data.source.dao.StudentDao;
import com.tr4n.sqliteanddao.data.source.dao.StudentDaoImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textStudents;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initViews() {
        textStudents = findViewById(R.id.textStudents);
    }

    private void initData() {
        initDao();
        //insertDataToDb();
        getData();
    }

    private void initDao() {
        AppDatabase database = AppDatabase.getInstance(this);
        studentDao = new StudentDaoImpl(database);
    }

    private void insertDataToDb() {
        for (int i = 0; i < 10; i++) {
            String name = "Nguyen Van " + (char) ((int) 'A' + i);
            Student student = new Student(i, name, "CNTT11-K62");
            studentDao.create(student);
        }
    }

    private void getData(){
        List<Student> students = studentDao.getAll();
        for(Student student: students){
            textStudents.append(student.toString());
            textStudents.append("\n");
        }
        Log.d(TAG, "getData: " + students);
    }

}