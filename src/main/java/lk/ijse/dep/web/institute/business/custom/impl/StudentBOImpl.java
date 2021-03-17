package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.DAOFactory;
import lk.ijse.dep.web.institute.dao.DAOTypes;
import lk.ijse.dep.web.institute.dao.custom.StudentDAO;
import lk.ijse.dep.web.institute.dto.StudentDTO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public StudentBOImpl() {
        studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
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
