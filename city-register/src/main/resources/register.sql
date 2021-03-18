DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

--1. Район
CREATE TABLE cr_district(
                            district_code integer not null,
                            district_name varchar(300),
                            PRIMARY KEY (district_code)
);
--2. Улица
CREATE TABLE cr_street(
                          street_code integer not null,
                          street_name varchar(300),
                          PRIMARY KEY (street_code)
);
--3. Адрес - район, улица, дом, корпус
CREATE TABLE  cr_address (
                             address_id SERIAL,
                             district_code integer not null,
                             street_code integer not null,
                             building varchar(10) not null,
                             extension varchar(10),
                             apartment varchar(10),
                             PRIMARY KEY (address_id),
                             FOREIGN KEY (district_code) REFERENCES cr_district(district_code) ON DELETE RESTRICT ,
                             FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT
);
--4. Персона - ФИО, дата рождения, Паспорт (серия/номер/дата выдачи), свидетельство о рождении (Номер/Дата)
CREATE TABLE cr_person (
                           person_id SERIAL,
                           sur_name varchar(100) not null,
                           given_name varchar(100) not null,
                           patronymic varchar(100) not null,
                           date_of_birth date not null,
                           passport_seria varchar(100),
                           passport_number varchar(100),
                           passport_date date null,
                           certificate_number varchar(10) null,
                           certificate_date date null,
                           PRIMARY KEY (person_id)
);
--5. Связь персоны и адреса - Персона, адрес и даипазон дат, вид регистрации
CREATE TABLE cr_address_person (
                                   person_address_id SERIAL,
                                   address_id integer not null,
                                   person_id integer not null,
                                   start_date date not null,
                                   end_date date,
                                   temporal boolean DEFAULT false,
                                   PRIMARY KEY (person_address_id),
                                   FOREIGN KEY (address_id) REFERENCES cr_address(address_id) ON DELETE RESTRICT,
                                   FOREIGN KEY (person_id) REFERENCES cr_person(person_id) ON DELETE RESTRICT
);

