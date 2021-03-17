package lk.ijse.dep.web.institute.entity;


import lk.ijse.dep.web.institute.util.Audience;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "course")
public class Course implements SuperEntity {
    @Id
    private String code;
    private String description;
    private String duration;
    @Enumerated(EnumType.ORDINAL)
    private Audience audience;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    public Course(String code, String description, String duration, Audience audience) {
        this.code = code;
        this.description = description;
        this.duration = duration;
        this.audience = audience;
    }
}
