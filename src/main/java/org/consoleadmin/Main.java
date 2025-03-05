package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Contracter u = new Contracter();
        u.setUid(1);
        u.setName("consoleAdmin");
        u.setTech("hibernate");


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Contracter.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(u);

        transaction.commit();

        session.close();
        sf.close();

    }
}