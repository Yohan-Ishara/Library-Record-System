package lk.ijse.dep.web.institute.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse implements SuperEntity {
    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    @Column(name = "register_date", nullable = false)
    private Date registerDate;
    @Column(name = "register_fee", nullable = false)
    private BigDecimal registerFee;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "course_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Course course;

    public StudentCourse(StudentCoursePK studentCoursePK, Date registerDate, BigDecimal registerFee) {
        this.studentCoursePK = studentCoursePK;
        this.registerDate = registerDate;
        this.registerFee = registerFee;
    }

    public StudentCourse(int studentId, String courseCode, Date registerDate, BigDecimal registerFee) {
        this.studentCoursePK = new StudentCoursePK(studentId, courseCode);
        this.registerDate = registerDate;
        this.registerFee = registerFee;
    }

}
