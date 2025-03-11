package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        ContracterDetails cDetail = new ContracterDetails();
        cDetail.setcId(12);
        cDetail.setCompanyName("Console Tech");
        cDetail.setPaymentAmount(109021);
        cDetail.setCoveredAreaName("New York");

        Contracter u = new Contracter();
        u.setUid(1);
        u.setName("consoleAdmin");
        u.setTech("hibernate");
        u.setContracterConfigs(cDetail);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Contracter.class)
                .addAnnotatedClass(ContracterDetails.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(cDetail); // mapping cDetail and persisting
        session.persist(u);

        transaction.commit();

        Contracter output = session.get(Contracter.class,1);
        System.out.println(output);

        // session close
        session.close();
        sf.close();

    }
}