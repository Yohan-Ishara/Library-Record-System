package lk.ijse.dep.web.institute.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class StudentCoursePK implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_code")
    private  String courseCode;
}
