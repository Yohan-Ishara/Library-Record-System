package lk.ijse.dep.web.institute.business.custom;

import lk.ijse.dep.web.institute.business.SuperBO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/
public interface StudentCourseBO extends SuperBO {

    public void register(StudentCourseDTO dto) throws Exception;
    //todo: check this method to register course with student
}
