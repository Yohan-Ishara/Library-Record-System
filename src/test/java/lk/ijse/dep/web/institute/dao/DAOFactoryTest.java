package lk.ijse.dep.web.institute.dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-04
 **/
public class DAOFactoryTest {

    @Test
    public void getInstance() {
        assertNotNull(DAOFactory.getInstance());
        assertEquals(DAOFactory.getInstance(), DAOFactory.getInstance());
    }

    @Test
    public void getDAO() {
        assertNotNull(DAOFactory.getInstance().getDAO(DAOTypes.COURSE));
    }
}
