DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person
(
    person_id  SERIAL,
    sex smallint not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    patronymic varchar(100) not null,
    date_birth date         not null,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport
(
    passport_id  SERIAL,
    person_id integer not null,
    seria varchar(10) not null,
    number  varchar(10) not null,
    issue_date date not null,
    issue_department varchar(100) not null,
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate
(
    birth_certificate_id  SERIAL,
    number_certificate varchar(20) not null,
    date_issue date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate
(
    marriage_certificate_id  SERIAL,
    number_certificate varchar(20) not null,
    date_issue date not null,
    husband_id integer,
    wife_id integer,
    active boolean,
    end_date date,
    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person(sex, first_name, last_name, patronymic, date_birth)
VALUES (2,'Елена','Васильева','Сергеевна','1998-03-24'),
       (1,'Олег','Васильев','Петрович','1997-10-15'),
       (1,'Николай','Васильев','Олегович','2018-10-21');

INSERT INTO ro_passport(person_id, seria, number, issue_date, issue_department)
VALUES (1,4000,123456,'2012-01-05','Office station department');

INSERT INTO ro_birth_certificate(birth_certificate_id,number_certificate,date_issue,person_id,father_id,mother_id)
VALUES (1,123,'2018-10-25',3,2,1);