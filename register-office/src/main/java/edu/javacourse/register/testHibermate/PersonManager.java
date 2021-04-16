package edu.javacourse.register.testHibermate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonManager {

    public static void main(String[] args) {

        //sessionExample();
        jpaExample();

    }

    private static void jpaExample() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        PersonTest p = new PersonTest();
        p.setFirstName("Максим");
        p.setLastName("Лавров");

        em.persist(p);

        System.out.println(p.getId());

        em.getTransaction().commit();

        em = emf.createEntityManager();

        List list = em.createQuery("FROM PersonTest").getResultList();

        list.forEach(person -> System.out.println(person));

        em.close();
    }

    private static void sessionExample() {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();

        session.getTransaction().begin();

        PersonTest p = new PersonTest();
        p.setFirstName("Алексей");
        p.setLastName("Иванов");

        Long id = (Long) session.save(p);

        System.out.println(id);

        session.getTransaction().commit();

        session.get(PersonTest.class,id);

        System.out.println(p);

        List<PersonTest> list = session.createQuery("FROM PersonTest", PersonTest.class).list();

        list.forEach(person -> System.out.println(person));

        session.close();
    }

    private static SessionFactory  buildSessionFactory(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();

    }
}
