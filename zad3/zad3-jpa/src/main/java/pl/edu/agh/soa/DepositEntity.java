package pl.edu.agh.soa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class DepositEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private int number;

    @Column
    private Double balance;

}
