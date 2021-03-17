package lk.ijse.dep.web.institute.dto;

import lk.ijse.dep.web.institute.entity.Address;
import lk.ijse.dep.web.institute.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO implements Serializable {

    private int id;
    private String studentName;
    private String contact;
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate dob;
    private Gender gender;
    private String no;
    private String addressLine1;
    private String addressLine2;
    private String city;
}
