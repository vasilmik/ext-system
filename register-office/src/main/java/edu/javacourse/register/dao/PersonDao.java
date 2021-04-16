package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;

import javax.persistence.*;
import java.util.List;

public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    /*
    public List<Person> findPersons(){
        return entityManager.createQuery(
                "SELECT p FROM Person p LEFT JOIN fetch p.passports ps LEFT JOIN FETCH p.birthCertificate bs"
                ).getResultList();
    }*/
    public List<Person> findPersons() {

        Query findPerson = entityManager.createNamedQuery("findPerson");
        findPerson.setParameter("PersonID", 2L);
        return findPerson.getResultList();

    }

    public Long addPerson(Person person) {

        entityManager.persist(person);
        entityManager.flush();

        return person.getPersonId();
    }
}
