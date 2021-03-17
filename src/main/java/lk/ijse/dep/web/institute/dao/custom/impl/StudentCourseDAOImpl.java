package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.CrudDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.entity.StudentCourse;
import org.springframework.stereotype.Component;

@Component
public class StudentCourseDAOImpl extends CrudDAOImpl<StudentCourse, String> implements StudentCourseDAO {

}
