package org.example.loginproject.repository.impl;

import lombok.Getter;
import org.example.loginproject.model.BaseModel;
import org.example.loginproject.repository.BaseRepository;
import org.example.loginproject.utility.EntityManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
@Getter
public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Serializable> implements BaseRepository<T, ID> {
    private final EntityManagerFactory emf = EntityManagement.getEntityManagerFactory();

    abstract Class<T> getEntityClass();
    @Override
    public void save(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(ID id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager
                .createQuery("from " + getEntityClass().getSimpleName(), getEntityClass())
                .getResultList();
    }

    @Override
    public void delete(T entity) {

    }
}
