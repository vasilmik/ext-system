package edu.javacourse.student.service;

import edu.javacourse.student.dao.StudentRepository;
import edu.javacourse.student.domain.Student;
import edu.javacourse.student.domain.StudentDocument;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentRequestSpring;
import edu.javacourse.student.view.StudentResponse;
import edu.javacourse.student.view.StudentResponseSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceSpring {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceSpring.class);

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentResponseSpring> getStudentInfo(StudentRequestSpring request) {

        List<Student> students = studentRepository.findStudent(
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getDateOfBirth(),
                request.getPassportSeria(),
                request.getPassportNumber(),
                request.getPassportDate());

        if (students.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        List<StudentDocument> docs = students.get(0).getDocuments();
        List<StudentResponseSpring> result = docs.stream().map(d->getResponse(d)).collect(Collectors.toList());

        return result;
    }

    private StudentResponseSpring getResponse(StudentDocument doc){

        StudentResponseSpring sr = new StudentResponseSpring();
        sr.setDocumentNumber(doc.getDocumentNumber());
        sr.setDocumentDate(doc.getDocumentDate());
        sr.setExpiredDate(doc.getExpiredDate());
        sr.setFacultyName(doc.getFaculty().toString());
        sr.setUniversityName(doc.getFaculty().getUniversity().getUniversityName());
        sr.setStudentFom(doc.getStudentForm().toString());

        return sr;

    }
}
