package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.DAOFactory;
import lk.ijse.dep.web.institute.dao.DAOTypes;
import lk.ijse.dep.web.institute.dao.SuperDAO;
import lk.ijse.dep.web.institute.dao.custom.CourseDAO;
import lk.ijse.dep.web.institute.entity.Course;
import lk.ijse.dep.web.institute.util.Audience;
import lk.ijse.dep.web.institute.util.JPAUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-04
 **/
public class CourseDAOImplTest {

    @Test
    public void save() throws Exception {
        Course course = new Course("C001", "java", "10", Audience.AFTERAL);
        CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
        courseDAO.setEntityManager(JPAUtil.getEntityManagerFactory().createEntityManager());
        courseDAO.save(course);
//        Course course1 = courseDAO.get("C001");
//        assertNotNull(course1);

        //todo: why database doesn't save the course during test?
    }

    @Test
    public void getAll() throws Exception {
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.setEntityManager(JPAUtil.getEntityManagerFactory().createEntityManager());
        courseDAO.getAll().forEach(System.out::println);
        assertTrue(courseDAO.getAll().size() > 0);
    }
}
