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

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class Address implements Serializable {

    private String no;
    @Column(name="address_line_1")
    private String addressLine1;
    @Column(name="address_line_2")
    private String addressLine2;
    private String city;
}
