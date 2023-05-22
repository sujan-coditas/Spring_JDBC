package org.example.dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentDaoImpl implements StudentDaoInterface{
    private JdbcTemplate template;

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void insert() throws IOException {
        System.out.println("Enter id");
        int id = Integer.parseInt(bf.readLine());
        System.out.println("Enter name");
        String name = bf.readLine();
        System.out.println("Enter city");
        String city = bf.readLine();
        String query = "insert into student (id, name, city) values (?, ?, ?)";
        template.update(query, id, name, city);
        System.out.println("Data inserted");
    }

    @Override
    public void update() throws IOException {
        System.out.println("Enter id");
        int id = Integer.parseInt(bf.readLine());
        System.out.println("Enter name");
        String name = bf.readLine();
        String query = "update student set name=? where id=?";
        template.update(query,  name,id);
        System.out.println("Data updated");
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Enter id");
        int id = Integer.parseInt(bf.readLine());
        String query = "delete from student where id=?";
        template.update(query, id);
        System.out.println("Data deleted");
    }

    public void getStudentById() throws IOException {
        System.out.println("Enter id");
        int id= Integer.parseInt(bf.readLine());
        String query="select * from student where id= ?";
        RowMapper<Student> rowMapper= new RowMapperImpl();
        Student student=template.queryForObject(query,rowMapper,id);
        System.out.println(student);

    }

    @Override
    public void studentList() {
        String query = "SELECT * FROM student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> students = template.query(query, rowMapper);

        students.stream().forEach(student -> System.out.println(student));

    }



}
