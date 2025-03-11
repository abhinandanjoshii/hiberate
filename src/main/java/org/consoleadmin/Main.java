package org.consoleadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ContracterDetails cDetailOne = new ContracterDetails();
        cDetailOne.setcId(12);
        cDetailOne.setCompanyName("Console Tech");
        cDetailOne.setPaymentAmount(109021);
        cDetailOne.setCoveredAreaName("New York");

        ContracterDetails cDetailTwo = new ContracterDetails();
        cDetailTwo.setcId(122);
        cDetailTwo.setCompanyName("Tech Console");
        cDetailTwo.setPaymentAmount(100);
        cDetailTwo.setCoveredAreaName("Los Angeles");


        Contracter u = new Contracter();
        u.setUid(1);
        u.setName("consoleAdmin");
        u.setTech("hibernate");
        u.setContractersConfigs(Arrays.asList(cDetailOne,cDetailTwo));

        cDetailOne.setContracter(u);
        cDetailTwo.setContracter(u);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Contracter.class)
                .addAnnotatedClass(ContracterDetails.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(cDetailOne); // mapping cDetailOne and persisting
        session.persist(cDetailTwo);
        session.persist(u);

        transaction.commit();

        Contracter output = session.get(Contracter.class,1);
        System.out.println(output);

        // session close
        session.close();
        sf.close();

    }
}