package co.pragra.banking.rest.simplebankapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.Instant;

@Entity
@Table(name = "bank_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long id;

    @Column(name = "CUSTOMER_NAME", nullable = false, length = 255)
    private String name;

    @Column(name = "PHONE")
    @Pattern(regexp = "^(\\+0?1\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")
    private String phone;

    @Column(name = "CREATE_DATE")
    private Instant createDate;


}
