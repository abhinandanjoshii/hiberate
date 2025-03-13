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

        int id = 13;
        Query query = session.createQuery("from ContracterDetails where cId=?1");
        query.setParameter(1,id);
        List<ContracterDetails> list = query.getResultList();
        // Lazy Fetching
        ContracterDetails contracterDetailss = session.byId(ContracterDetails.class).getReference(2);
        // Normal Fetching
        ContracterDetails normal = session.get(ContracterDetails.class,2);
        System.out.println(list);
        session.close();
        sf.close();

    }
}