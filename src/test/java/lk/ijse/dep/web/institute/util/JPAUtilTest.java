package lk.ijse.dep.web.institute.util;

import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-04
 **/
public class JPAUtilTest {

    @Test
    public void getEntityManagerFactory() {
        assertNotNull(JPAUtil.getEntityManagerFactory());
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        assertNotNull(em);
        if(em != null){
            em.close();
        }
    }

    @Test
    public void getDataSource() {
        assertNotNull(JPAUtil.getDataSource());
    }
}
