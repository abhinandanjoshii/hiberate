package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(ContracterDetails.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Query query = session.createQuery("from ContracterDetails where cId=13");
        List<ContracterDetails> list = query.getResultList();

        System.out.println(list);
        session.close();
        sf.close();

    }
}