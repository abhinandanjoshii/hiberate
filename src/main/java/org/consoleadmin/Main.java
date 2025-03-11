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

        Contracter u3 = new Contracter();
        u3.setUid(3);
        u3.setName("Admin");
        u3.setTech("SpringBoot");

        u1.setContractersConfigs(Arrays.asList(cDetailOne,cDetailTwo));
        u2.setContractersConfigs(Arrays.asList(cDetailTwo,cDetailThree));
        u3.setContractersConfigs(Arrays.asList(cDetailOne));

        cDetailOne.setContracters(Arrays.asList(u1,u3));
        cDetailTwo.setContracters(Arrays.asList(u1,u2));
        cDetailThree.setContracters(Arrays.asList(u1));

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
        session.persist(u3);


        transaction.commit();

        Contracter output = session.get(Contracter.class,2);
        System.out.println(output);

        session.close();
        sf.close();

    }
}