package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Client c = new Client();
        c.setEmpAge(1);
        c.setEmpName("consoleAdminFive");
        c.setEmpId(110);

        Client c2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.consoleadmin.Client.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        c2 = session.get(Client.class,102);
        session.close();
        sf.close();

        System.out.println(c2);
    }
}