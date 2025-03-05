package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Client c = new Client();
        c.setEmpAge(23);
        c.setEmpName("consoleAdminSix");
        c.setEmpId(178);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.consoleadmin.Client.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // updating data if present, else create
        session.merge(c);

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(c);
    }
}