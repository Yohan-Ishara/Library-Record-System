package lk.ijse.dep.web.institute.business.custom;

import lk.ijse.dep.web.institute.business.SuperBO;
import lk.ijse.dep.web.institute.dto.StudentDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public interface StudentBO extends SuperBO {

    public void saveStudent(StudentDTO studentDTO) throws Exception;

    public void updateStudent(StudentDTO studentDTO) throws Exception;

    public void deleteStudent(Integer studentId) throws Exception;

    public List<StudentDTO> getAllStudents() throws Exception;

    public StudentDTO getStudent(Integer studentId) throws Exception;
}
