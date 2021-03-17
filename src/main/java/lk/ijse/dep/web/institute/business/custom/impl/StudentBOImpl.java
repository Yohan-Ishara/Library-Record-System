package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentDAO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class StudentBOImpl implements StudentBO {
    @Autowired
    private  StudentDAO studentDAO;
    private EntityManager em;
    @Autowired
    private  EntityDTOMapper mapper;

    public StudentBOImpl() {

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentDAO.setEntityManager(em);
    }

    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.save(mapper.getStudent(dto));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.update(mapper.getStudent(dto));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteStudent(Integer studentId) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.delete(studentId);
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        try {
            em.getTransaction().begin();
            List<StudentDTO> studentDTOS = mapper.getStudentDTOs(studentDAO.getAll());
            em.getTransaction().commit();
            return studentDTOS;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public StudentDTO getStudent(Integer studentId) throws Exception {
        try {
            em.getTransaction().begin();
            StudentDTO studentDTO = mapper.getStudentDTO(studentDAO.get(studentId));
            em.getTransaction().commit();
            return studentDTO;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}
