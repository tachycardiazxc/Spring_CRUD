package com.kata.project.repository;

import com.kata.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImp(EntityManagerFactory factoryBean) {
        this.entityManagerFactory = factoryBean;
    }

    @Override
    public void add(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

        entityManager.getTransaction().commit();
    }

    @Override
    public void patch(long id, User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User oldUser = entityManager.find(User.class, id);
        entityManager.detach(oldUser);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        entityManager.getTransaction().begin();
        entityManager.merge(oldUser);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> get() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }
}
