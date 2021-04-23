package edu.javacourse.student;

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.view.StudentRequest;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Starter {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"springContext.xml"});

        StudentService service = context.getBean(StudentService.class);
        service.getStudentInfo(new StudentRequest());

    }

}
