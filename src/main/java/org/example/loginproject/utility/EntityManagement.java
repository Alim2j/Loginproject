package org.example.loginproject.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagement {
    private static EntityManagerFactory emf;

    public EntityManagement() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        return emf;
    }
}

