package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Client c = new Client();
        c.setEmpAge(21);
        c.setEmpName("consoleAdmin");
        c.setEmpId(12);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.consoleadmin.Client.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();


    }
}