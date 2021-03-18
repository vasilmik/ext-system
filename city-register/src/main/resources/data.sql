INSERT INTO cr_district(district_code, district_name)
VALUES(1,'Выборгский');

INSERT INTO cr_street(street_code,street_name)
VALUES(1,'Садовая');

INSERT INTO cr_address(district_code, street_code, building, extension, apartment)
VALUES (1,1,'8','2','1');

INSERT INTO cr_person(sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number, certificate_date)
VALUES ('Vasilev','Michael','Vladimirovich','1990-03-31','1234','123456','2010-04-01',null,null);

INSERT INTO cr_person(sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number, certificate_date)
VALUES ('Vasileva','Irina','Nicolaevna','1990-12-29','4321','654321','2011-02-07',NULL,NULL);

INSERT INTO cr_person(sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number, certificate_date)
VALUES ('Vasileva','Milana','Mihailovna','2020-01-01',null,null,null,'456123','2020-01-25');

INSERT INTO cr_person(sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number, certificate_date)
VALUES ('Vasilev','Fedor','Mihailovich','2021-01-01',null,null,null,'987456','2021-01-15');

INSERT INTO cr_address_person(ADDRESS_ID, PERSON_ID, START_DATE, END_DATE,temporal)
VALUES(1,1,'2014-10-12',NULL,false);

INSERT INTO cr_address_person(ADDRESS_ID, PERSON_ID, START_DATE, END_DATE)
VALUES(1,2,'2014-10-12',NULL);

INSERT INTO cr_address_person(ADDRESS_ID, PERSON_ID, START_DATE, END_DATE)
VALUES(1,3,'2020-02-05',NULL);

INSERT INTO cr_address_person(ADDRESS_ID, PERSON_ID, START_DATE, END_DATE)
VALUES(1,4,'2021-01-30',NULL);