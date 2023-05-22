package org.example.dao;

import org.example.entities.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDaoInterface {
    public void insert( ) throws IOException;
    public void update( ) throws IOException;
    public void delete( ) throws IOException;
    public void getStudentById( ) throws IOException;
    void studentList();


}
