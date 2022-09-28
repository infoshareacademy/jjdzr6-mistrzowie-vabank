package com.infoshareacademy.mistrzowieVaBank.dao;


import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.WineForm;
import com.infoshareacademy.mistrzowieVaBank.pagination.PaginationResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.time.LocalDate;

@Transactional
@Repository
public class WineDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Wine findWine(Long id) {
        try {
            String sql = "Select e from " + Wine.class.getName() + " e Where e.code =:code ";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Wine> query = session.createQuery(sql, Wine.class);
            query.setParameter("id", id);
            return (Wine) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public WineInfo findProductInfo(Long id) {
        Wine wine = this.findWine(id);
        if (wine == null) {
            return null;
        }
        return new WineInfo(wine.getId(), wine.getName(), wine.getPrice());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void save(WineForm wineForm) {

        Session session = this.sessionFactory.getCurrentSession();
        Long id = wineForm.getId();

        Wine wine = null;

        boolean isNew = false;
        if (id != null) {
            wine = this.findWine(id);
        }
        if (wine == null) {
            isNew = true;
            wine = new Wine();
            wine.setCreateDate(LocalDate.now());
        }
        wine.setId(id);
        wine.setName(wineForm.getName());
        wine.setPrice(wineForm.getPrice());

        if (wineForm.getFileData() != null) {
            byte[] image = null;
            try {
                image = wineForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            if (image != null && image.length > 0) {
                wine.setImage(image);
            }
        }
        if (isNew) {
            session.persist(wine);
        }
        // If error in DB, Exceptions will be thrown out immediately
        session.flush();
    }

    public PaginationResult<WineInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
                                                    String likeName) {
        String sql = "Select new " + WineInfo.class.getName() //
                + "(p.id, p.name, p.price) " + " from "//
                + Wine.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        }
        sql += " order by p.createDate desc ";
        //
        Session session = this.sessionFactory.getCurrentSession();
        Query<WineInfo> query = session.createQuery(sql, WineInfo.class);

        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<WineInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<WineInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
        return queryProducts(page, maxResult, maxNavigationPage, null);
    }

}