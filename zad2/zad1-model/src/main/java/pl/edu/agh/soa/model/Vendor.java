package pl.edu.agh.soa.model;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder={"firstName", "lastName","nickname","id","country","products"})
public class Vendor {

    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String country;
    private List<Product> products = new ArrayList<>();

    public Vendor(String firstName, String lastName,String nickname, int id, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.id = id;
        this.country = country;
    }

    public Vendor(String firstName, String lastName,String nickname, int id, String country, List<Product> products) {
        this(firstName, lastName, nickname, id, country);
        this.products = products;
    }

    public Vendor() {
        //No-arg constructor is just to keep JAXB from complaining
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getCountry() {
        return this.country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByPid(int pid){
        for(Product product: this.products){
            if(product.getPid() == pid){
                return product;
            }
        }
        return null;
    }
}
