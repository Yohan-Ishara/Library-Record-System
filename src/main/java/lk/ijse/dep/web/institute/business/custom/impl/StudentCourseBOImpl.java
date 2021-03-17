package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;



@Service
@Transactional
public class StudentCourseBOImpl implements StudentCourseBO {

    private EntityManager em;
    @Autowired
    private  StudentCourseDAO studentCourseDAO;
    @Autowired
    private  EntityDTOMapper mapper;

    public StudentCourseBOImpl() {

    }

    @Override
    public void register(StudentCourseDTO dto) throws Exception {
            studentCourseDAO.save(mapper.getStudentCourse(dto));
    }

    //todo:- check whole class
}
