package lk.ijse.dep.web.institute.business;

import lk.ijse.dep.web.institute.business.custom.impl.CourseBOImpl;
import lk.ijse.dep.web.institute.business.custom.impl.StudentBOImpl;
import lk.ijse.dep.web.institute.business.custom.impl.StudentCourseBOImpl;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENTCOURSE:
                return (T) new StudentCourseBOImpl();
            default:
                return null;
        }
    }
}
