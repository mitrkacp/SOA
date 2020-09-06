package pl.edu.agh.soa.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@NoArgsConstructor
@XmlType(propOrder = {"number","balance"})
public class Deposit {
    private int number;
    private Double balance;

    public Deposit(int number, Double balance){
        this.number = number;
        this.balance = balance;
    }
}
