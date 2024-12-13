package org.example.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", new BufferedReader(new FileReader("pwd")).readLine())
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new Person("A", new Date(26, Calendar.APRIL, 1986)));
        session.save(new Person("B", new Date(07, Calendar.JULY, 1991)));
        session.save(new Person("C", new Date()));
        session.getTransaction().commit();
        session.close();
    }
}
