package org.example;

import org.example.dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Application Started............!");

        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
//        JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
//        String query="insert into student(id,name,city) values(?,?,?)";
//        int result=template.update(query,456,"anuj","pune");
//        System.out.println("no of lines inserted "+result);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);
        boolean exit = true;
        while (exit) {
            System.out.println("Enter \n 0.EXIT \n 1. INSERT \n 2.UPDATE \n 3.DELETE \n 4. GET STUDENT BY ID \n 5. All Students");
            int choice = Integer.parseInt(bf.readLine());
            switch (choice) {
                case 1:
                    studentDao.insert();
                    break;
                case 2:
                    studentDao.update();
                    break;
                case 3:
                    studentDao.delete();
                    break;
                case 4:
                    studentDao.getStudentById();
                    break;


                case 5:
                    studentDao.studentList();
                    break;
                case 0:
                    exit = false;
                    break;

                default:
                    System.out.println("Enter valid option");
                    break;
            }
        }
    }
}
        /*
            ************OUTPUT***********
            Application Started............!
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
5
Student{id=1, name='aarti', city='nanded'}
Student{id=456, name='anuj', city='pune'}
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
1
Enter id
2
Enter name
sujan
Enter city
nanded
Data inserted
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
2
Enter id
1
Enter name
mani
Data updated
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
3
Enter id
1
Data deleted
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
4
Enter id
2
Student{id=2, name='sujan', city='nanded'}
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
5
Student{id=456, name='anuj', city='pune'}
Student{id=2, name='sujan', city='nanded'}
Enter
 0.EXIT
 1. INSERT
 2.UPDATE
 3.DELETE
 4. GET STUDENT BY ID
 5. All Students
0

Process finished with exit code 0*/
