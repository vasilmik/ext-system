package edu.javacourse.student.service;

import edu.javacourse.student.rest.StudentController;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class StudentServiceTestMain {

    @Autowired
    private StudentController studentController;

    @Test
    public void infoStudent(){

        StudentRequest request = new StudentRequest();
        request.setLastName("Vasilyev");
        request.setFirstName("Michael");
        request.setMiddleName("Vladimirovich");
        request.setDateOfBirth(LocalDate.of(1992,3,31));
        request.setPassportNumber("123456");
        request.setPassportSeria("1234");
        request.setPassportDate(LocalDate.of(2004,4,1));

       List<StudentResponse> studentInfo = studentController.getStudentInfo(request);

        for (StudentResponse sr:studentInfo) {
            System.out.println(sr);
        }

        System.out.println("TEST!");
    }

}