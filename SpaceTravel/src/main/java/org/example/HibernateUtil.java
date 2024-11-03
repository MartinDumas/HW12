package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/HW12", "postgres", "2490")
                .locations("db/migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();


        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

    }
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void closeSession(){
        sessionFactory.close();
    }


}
