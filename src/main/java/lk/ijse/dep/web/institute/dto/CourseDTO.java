package lk.ijse.dep.web.institute.dto;

import lk.ijse.dep.web.institute.util.Audience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data @NoArgsConstructor @AllArgsConstructor
public class CourseDTO implements Serializable {

    private String code;
    private String description;
    private String duration;
    private Audience audience;
}
