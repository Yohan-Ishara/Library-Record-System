package lk.ijse.dep.web.institute.entity;

import lk.ijse.dep.web.institute.util.Gender;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to get same state  as JDBC auto increment
    private int id;
    @Column(name = "student_name")
    private String studentName;
    private String contact;
    private Date dob;
    private Gender gender;
    @Embedded
    private Address address;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourses;

    public Student(int id, String studentName, String contact, Date dob, Gender gender, Address address) {
        this.id = id;
        this.studentName = studentName;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }
}

