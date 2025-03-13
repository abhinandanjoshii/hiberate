package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(ContracterDetails.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        // Level 1 Cache
        ContracterDetails c1= session.get(ContracterDetails.class,13);
        System.out.println(c1);
        ContracterDetails c2= session.get(ContracterDetails.class,13);
        System.out.println(c2);

        Session s1 = sf.openSession();
        ContracterDetails cc = s1.get(ContracterDetails.class,13);
        System.out.println(cc);
        s1.close();


        session.close();
        sf.close();

    }
}