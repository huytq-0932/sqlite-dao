package com.tr4n.sqliteanddao.data.source.dao;

import com.tr4n.sqliteanddao.data.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAll();

    void create(Student student);
}
