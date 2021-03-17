package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.custom.QueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class QueryDAOImpl implements QueryDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

