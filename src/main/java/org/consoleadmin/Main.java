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

        ContracterDetails cDetailThree = new ContracterDetails();
        cDetailThree.setcId(3);
        cDetailThree.setCompanyName("Abhii Tech Console");
        cDetailThree.setPaymentAmount(200);
        cDetailThree.setCoveredAreaName("Ireland");


        Contracter u1 = new Contracter();
        u1.setUid(1);
        u1.setName("consoleAdmin");
        u1.setTech("hibernate");

        Contracter u2 = new Contracter();
        u2.setUid(2);
        u2.setName("AdminConsoleAdmin");
        u2.setTech("C#");

        u1.setContractersConfigs(Arrays.asList(cDetailOne,cDetailTwo));
        u2.setContractersConfigs(Arrays.asList(cDetailThree));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Contracter.class)
                .addAnnotatedClass(ContracterDetails.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(cDetailOne);
        session.persist(cDetailTwo);
        session.persist(cDetailThree);

        session.persist(u1);
        session.persist(u2);

        transaction.commit();

        Session cacheCheck = sf.openSession();

        Contracter output = cacheCheck.get(Contracter.class,1);
//        System.out.println(output);

        cacheCheck.close();
        session.close();
        sf.close();

    }
}