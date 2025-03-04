package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Client c = new Client();
        c.setEmpAge(1);
        c.setEmpName("consoleAdminFive");
        c.setEmpId(110);

        Client c2 = null;

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.consoleadmin.Client.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.consoleadmin.Client.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(c); //using newer version
        transaction.commit();
        session.close();
        sf.close();

        System.out.println(c2);
    }
}