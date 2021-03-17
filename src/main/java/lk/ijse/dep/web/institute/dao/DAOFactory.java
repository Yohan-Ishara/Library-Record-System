package lk.ijse.dep.web.institute.dao;

import lk.ijse.dep.web.institute.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.impl.QueryDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.impl.StudentCourseDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.impl.StudentDAOImpl;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return (daoFactory != null)? daoFactory: (daoFactory = new DAOFactory());
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case STUDENTCOURSE:
                return  (T) new StudentCourseDAOImpl();
            default:
                return null;
        }
    }
}
