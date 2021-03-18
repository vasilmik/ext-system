package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

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

        PersonResponse ans = new PersonCheckDao().checkPerson(pr);

        Assert.assertTrue(ans.isRegistered());
        Assert.assertFalse(ans.isTemporal());
    }
}