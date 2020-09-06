package pl.edu.agh.soa;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String nickname;

    @Column
    private int vendorId;

    @Column
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    private DepositEntity depositEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> productsEntities;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "vendor_has_category",
            joinColumns = {
                    @JoinColumn(name = "vendorID", referencedColumnName = "idx")
            }, inverseJoinColumns = {@JoinColumn (name = "categoryID", referencedColumnName = "idx" )})
    private List<CategoryEntity> categories;

}
