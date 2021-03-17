package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.CrudDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.CourseDAO;
import lk.ijse.dep.web.institute.entity.Course;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl extends CrudDAOImpl<Course, String> implements CourseDAO {
}
