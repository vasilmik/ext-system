package edu.javacourse.student.rest;

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.service.StudentServiceSpring;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentRequestSpring;
import edu.javacourse.student.view.StudentResponse;
import edu.javacourse.student.view.StudentResponseSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentControllerSpring {

    @Autowired
    private StudentServiceSpring studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<StudentResponseSpring> getStudentInfo(@RequestBody StudentRequestSpring request){
        return studentService.getStudentInfo(request);
    }

    @GetMapping(path = "/check")
    public String checkAdmin(){
        return "Rest Spring is working";
    }

    @GetMapping(path = "/studentAnswer",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StudentRequestSpring getStudentInfo(){

        StudentRequestSpring request = new StudentRequestSpring();
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
