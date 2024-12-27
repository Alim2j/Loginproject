package org.example.loginproject.repository.impl;

import org.example.loginproject.model.User;
import org.example.loginproject.repository.BaseRepository;
import org.example.loginproject.repository.UserRepository;
import org.example.loginproject.utility.EntityManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    private final EntityManagerFactory emf = EntityManagement.getEntityManagerFactory();

    @Override
    Class<User> getEntityClass() {
        return User.class;
    }

/*    @Override
    public Optional<User> findByUserName(String username) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> employeeRoot = criteriaQuery.from(User.class);

        Predicate namePredicate = criteriaBuilder.like(employeeRoot.get("username"), "%" + username + "%");

        criteriaQuery.where(criteriaBuilder.and(namePredicate));

        User user = em.createQuery(criteriaQuery).getSingleResult();
        return Optional.of(user);
    }*/

    @Override
    public Optional<User> signIn(String username, String password) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username and u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        if (users.size() == 1) {
            return Optional.of(users.get(0));
        } else if (users.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(users.get(0));
        }
    }
}
