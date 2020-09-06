package pl.edu.agh.soa;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private int quantity;

    @Column(length = 2000)
    private String encoded64BaseImage;

    @Column
    private int productId;

}
