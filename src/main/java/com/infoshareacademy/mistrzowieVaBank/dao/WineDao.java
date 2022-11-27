package com.infoshareacademy.mistrzowieVaBank.dao;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Transactional
@Repository
public class WineDao {

    private final SessionFactory sessionFactory;

    public WineDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Wine findWine(Long id) {
        try {
            String sql = "Select e from " + Wine.class.getName() + " e Where e.id =:id ";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Wine> query = session.createQuery(sql, Wine.class);
            query.setParameter("id", id);
            return (Wine) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


}