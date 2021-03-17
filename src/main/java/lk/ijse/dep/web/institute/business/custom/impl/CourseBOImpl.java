package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.CourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.CourseDAO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CourseBOImpl implements CourseBO {
    @Autowired
    private CourseDAO courseDAO;
    private EntityManager em;
    @Autowired
    private EntityDTOMapper mapper;

    public CourseBOImpl() {

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        courseDAO.setEntityManager(em);
    }

    @Override
    @Transactional
    public void saveCourse(CourseDTO dto) throws Exception {
            courseDAO.save(mapper.getCourse(dto));
        }

    @Transactional
    @Override
    public void updateCourse(CourseDTO dto) throws Exception {

            courseDAO.update(mapper.getCourse(dto));
    }
    @Transactional
    @Override
    public void deleteCourse(String courseId) throws Exception {
            courseDAO.delete(courseId);
    }

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        try {
            em.getTransaction().begin();
            mapper.getCourseDTOs(courseDAO.getAll());
            List<CourseDTO> courseDTOS = mapper.getCourseDTOs(courseDAO.getAll());
            em.getTransaction().commit();
            return courseDTOS;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}
