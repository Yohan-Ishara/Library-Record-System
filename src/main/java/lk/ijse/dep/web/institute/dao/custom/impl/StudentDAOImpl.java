package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.CrudDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.StudentDAO;
import lk.ijse.dep.web.institute.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDAOImpl extends CrudDAOImpl<Student, Integer> implements StudentDAO {
}
