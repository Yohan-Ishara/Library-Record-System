package lk.ijse.dep.web.institute.business.custom;

import lk.ijse.dep.web.institute.business.SuperBO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import lk.ijse.dep.web.institute.dto.StudentDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public interface CourseBO extends SuperBO {

    public void saveCourse(CourseDTO courseDTO) throws Exception;

    public void updateCourse(CourseDTO courseDTO) throws Exception;

    public void deleteCourse(String courseCode) throws Exception;

    public List<CourseDTO> getAllCourses() throws Exception;
}
