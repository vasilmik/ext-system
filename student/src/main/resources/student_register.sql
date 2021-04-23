INSERT INTO sr_university(university_name) VALUES ('University 1');

INSERT INTO sr_faculty(faculty_name, university_id) VALUES ('IATIT',1);

INSERT INTO sr_student(date_of_birth, first_name, last_name, middle_name, passport_date, passport_number, passport_seria)
VALUES ('1992-03-31','Michael','Vasilyev','Vladimirovich','2004-04-01','123456','1234');

INSERT INTO sr_student_document(document_date, document_number, expired_date, student_form, faculty_id, student_id)
VALUES ('2008-09-01','555','2009-09-01',1,1,1);