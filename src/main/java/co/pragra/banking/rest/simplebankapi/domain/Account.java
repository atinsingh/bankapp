package co.pragra.banking.rest.simplebankapi.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TABLE_ACCOUNT")
@Data
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_NO", nullable = false)
    private Long accountNo;

    @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    private Customer customer;

    @Column(name = "ACCOUNT_BALANCE")
    private double amount;

    @Column(name = "CREATE_DATE")
    private Date openDate;


}
