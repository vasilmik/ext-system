package edu.javacourse.cityReg.dao;

import edu.javacourse.cityReg.domain.PersonRequest;
import edu.javacourse.cityReg.domain.PersonResponse;
import edu.javacourse.cityReg.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {

        PersonRequest pr = new PersonRequest();
        pr.setSurName("Vasilev");
        pr.setGivenName("Michael");
        pr.setPatronymic("Vladimirovich");
        pr.setDateOfBitch(LocalDate.of(1990,03,31));
        pr.setBuilding("8");
        pr.setExtension("2");
        pr.setApartment("1");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());

        PersonResponse ans = dao.checkPerson(pr);

        Assert.assertTrue(ans.isRegistered());
        Assert.assertFalse(ans.isTemporal());
    }
}