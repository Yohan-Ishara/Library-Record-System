package lk.ijse.dep.web.institute.business.util;

import lk.ijse.dep.web.institute.dto.CourseDTO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import lk.ijse.dep.web.institute.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-02
 **/
@Mapper(componentModel = "spring")
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(source = ".", target = "address")
    @Mapping(source = ".", target = "dob", qualifiedByName = "dob")
    Student getStudent(StudentDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "no", qualifiedByName = "no")
    @Mapping(source = ".", target = "addressLine1", qualifiedByName = "addressLine1")
    @Mapping(source = ".", target = "addressLine2", qualifiedByName = "addressLine2")
    @Mapping(source = ".", target = "city", qualifiedByName = "city")
    StudentDTO getStudentDTO(Student student);

    Course getCourse(CourseDTO dto);

    CourseDTO getCourseDTO(Course course);

    List<CourseDTO> getCourseDTOs(List<Course> course);

    List<StudentDTO> getStudentDTOs(List<Student> student);

    @Mapping(source = ".", target = "studentCoursePK")
    @Mapping(source = ".", target = "registerDate", qualifiedByName = "registerDate")
    StudentCourse getStudentCourse(StudentCourseDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "studentId", qualifiedByName = "studentId")
    @Mapping(source = ".", target = "courseCode", qualifiedByName = "courseCode")
    StudentCourseDTO getStudentCourseDTO(StudentCourse studentCourse);

    /*methods for get student from dto*/
    default Address getAddress(StudentDTO dto){
        return new Address(dto.getNo(), dto.getAddressLine1(), dto.getAddressLine2(), dto.getCity());
    }

    @Named("dob")
    default Date toDate(StudentDTO dto){
        return Date.valueOf(dto.getDob());
    }

    /*get dto from student*/
    @Named("no")
    default String getNo(Student student){ return student.getAddress().getNo(); }

    @Named("addressLine1")
    default String getAddressLine1(Student student){ return student.getAddress().getAddressLine1(); }

    @Named("addressLine2")
    default String getAddressLine2(Student student){ return student.getAddress().getAddressLine2(); }

    @Named("city")
    default String getCity(Student student){ return student.getAddress().getCity(); }


    /*method for get StudentCourse*/

    default StudentCoursePK getStudentCoursePK(StudentCourseDTO dto){
        return new StudentCoursePK(dto.getStudentId(), dto.getCourseCode());
    }

    @Named("registerDate")
    default Date toDate(StudentCourseDTO dto){
        return Date.valueOf(dto.getRegisterDate());
    }

    /*methods for get StudentCourseDTOs*/

    @Named("studentId")
    default int getStudentId(StudentCourse studentCourse){
        return studentCourse.getStudentCoursePK().getStudentId();
    }

    @Named("courseCode")
    default String getCourseCode(StudentCourse studentCourse){
        return studentCourse.getStudentCoursePK().getCourseCode();
    }
}
