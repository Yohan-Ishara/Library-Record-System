package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.CrudDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.entity.StudentCourse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCourseDAOImpl extends CrudDAOImpl<StudentCourse, String> implements StudentCourseDAO {

}
