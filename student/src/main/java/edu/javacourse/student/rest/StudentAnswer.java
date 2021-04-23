package edu.javacourse.student.rest;

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Component
@Path("/studentRequest")
public class StudentAnswer {

    @Autowired
    private StudentService studentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public StudentRequest getStudentInfo(){

        StudentRequest request = new StudentRequest();
        request.setLastName("Vasilyev");
        request.setFirstName("Michael");
        request.setMiddleName("Vladimirovich");
        request.setDateOfBirth(LocalDate.of(1992,3,31));
        request.setPassportNumber("123456");
        request.setPassportSeria("1234");
        request.setPassportDate(LocalDate.of(2004,4,1));

        return request;
    }

}
