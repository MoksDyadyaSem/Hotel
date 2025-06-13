package com.example.demo.executiveClasses;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Guest;
import com.example.demo.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Guest.class)
                .addAnnotatedClass(Employee.class);

        SessionFactory sf = cfg.buildSessionFactory();

        try (sf) {
            Session session = sf.getCurrentSession();
            session.beginTransaction();


            session.persist(new Employee(
                    "alex",
                    "89057503960",
                    "somemail@mail.ru",
                    "technician"
            ));

            session.getTransaction().commit();
        }
    }
}