package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/
public class StudentCourseBOImpl implements StudentCourseBO {

    private EntityManager em;
    @Autowired
    private  StudentCourseDAO studentCourseDAO;
    @Autowired
    private  EntityDTOMapper mapper;

    public StudentCourseBOImpl() {

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentCourseDAO.setEntityManager(em);
    }

    @Override
    public void register(StudentCourseDTO dto) {
        try {
            em.getTransaction().begin();
            studentCourseDAO.save(mapper.getStudentCourse(dto));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw new RuntimeException(t);
        }
    }

    //todo:- check whole class
}
