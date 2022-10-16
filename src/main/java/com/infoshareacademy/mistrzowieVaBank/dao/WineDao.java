package com.infoshareacademy.mistrzowieVaBank.dao;

import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.WineForm;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class WineDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private WineRepository wineRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveNewWine(NewWineInfo newWineInfo) {

        Wine wine = new Wine();
        String wineName = newWineInfo.getName();

        if (findUniqueNames(wineName) != null) {
            wine.setName(newWineInfo.getName());
        } else {
            wine.setName("");

        }
        wine.setFlavour(newWineInfo.getFlavour());
        wine.setType(newWineInfo.getType());
        wine.setYear(newWineInfo.getYear());
        wine.setOrigin(newWineInfo.getOrigin());
        wine.setPrice(newWineInfo.getPrice());
        wine.setQuantity(newWineInfo.getQuantity());
        wine.setSpec(newWineInfo.getSpec());
        wine.setCreateDate(LocalDate.now());

        wineRepository.save(wine);
    }

    public List<Wine> findUniqueNames(String name) {

        TypedQuery<Wine> query = entityManager.createQuery("select distinct e from Wine e where e.name = :name", Wine.class);
        query.setParameter("name", name);
        return new ArrayList<>(query.getResultList());

    }


}