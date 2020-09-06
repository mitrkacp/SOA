package pl.edu.agh.soa.model;

import com.sun.xml.ws.developer.Stateful;

import java.util.ArrayList;
import java.util.List;


@Stateful
public class VendorList {

    private List<Vendor> vendors;

    public VendorList() {
        this.vendors = new ArrayList<>();
    }

    public boolean addVendor(Vendor vendor) {
        return vendors.add(vendor);
    }

    public boolean deleteVendor(int id) {
        return vendors.removeIf(vendor -> vendor.getId() == id);
    }

    public List<Vendor> getVendors() {
        return this.vendors;
    }

    public Vendor getVendorById(int id){
        for(Vendor vendor : vendors) {
            if(vendor.getId() == id)
                return vendor;
        }
        return null;
    }

    public List<Vendor> getVendorsByCountry(String country){
        List<Vendor> result = new ArrayList<>();
        for(Vendor vendor : vendors) {
            if(vendor.getCountry().equals(country))
                result.add(vendor);
        }
        return result;
    }

    public static VendorList createSampleList(){

        VendorList sampleList = new VendorList();

        List<Category> c1 = new ArrayList<>();
        List<Category> c2 = new ArrayList<>();
        List<Category> c3 = new ArrayList<>();
        c1.add(new Category("Tools",null));
        c1.add(new Category("Sport",null));
        c2.add(new Category("Sport",null));
        c3.add(new Category("Music",null));

        Deposit d1 = new Deposit(1,100.0);
        Deposit d2 = new Deposit(2,0.0);
        Deposit d3 = new Deposit(3,444.0);

        Vendor v1 = new Vendor("Mirek","Dzban","mirexx",1, "Poland",c1,d1);
        Vendor v2 = new Vendor("Jason","Standalone","jason320",2, "United States",c2,d2);
        Vendor v3 = new Vendor("Janusz","Kozak","janoosh123",3, "Poland",c3,d3);

        v1.addProduct(new Product(1,"lawn mower", 666.0, 1, "iVBORw0KGgoAAAANSUhEUgAAABgAAAANCAIAAAA8DjmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABlSURBVDhPrZDBDcAgDMQ6S+dhWSZsT/UnCkmEUk5+QHRYwHXPcYS/oueLFn0RCoVtU2QV0BGtFuFFYcmSFYIbZVXmiptD/LS1XSgg/SN7rFZAJeL8jkWkIoFLcfOQSiSOiXaZ4wViCJe6YgW9QwAAAABJRU5ErkJggg=="));
        v1.addProduct(new Product(2,"tyre", 100.0, 4));
        v2.addProduct(new Product(3,"fluorescent lamp", 216.0, 3));
        v2.addProduct(new Product(4,"fishing rod", 300.0, 1));
        v3.addProduct(new Product(5,"machete", 144.0, 1));

        sampleList.addVendor(v1);
        sampleList.addVendor(v2);
        sampleList.addVendor(v3);

        return sampleList;
    }
}
