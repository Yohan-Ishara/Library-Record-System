package lk.ijse.dep.web.institute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentCourseDTO implements Serializable {

    private int studentId;
    private String courseCode;
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate registerDate;
    private BigDecimal registerFee;
}
