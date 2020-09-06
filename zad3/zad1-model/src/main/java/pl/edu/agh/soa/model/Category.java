package pl.edu.agh.soa.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@XmlType(propOrder = {"name","vendorList"})
public class Category {

    private String name;
    private List<Vendor> vendorList;

    public Category(String name, List<Vendor> vendorList){
        this.name = name;
        this.vendorList = vendorList;
    }
}
