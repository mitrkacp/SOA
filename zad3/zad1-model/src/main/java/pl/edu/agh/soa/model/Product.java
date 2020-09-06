package pl.edu.agh.soa.model;

import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@XmlType(propOrder={"pid","name","price","quantity","encoded64BaseImage"})
public class Product {

    private int pid;
    private String name;
    private double price;
    private int quantity;
    private String encoded64BaseImage;

    public Product(){

    }

    public Product(int pid, String name, Double price, int quantity,String encoded64BaseImage){
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.encoded64BaseImage = encoded64BaseImage;
    }

    public Product(int pid,String name,double price, int quantity){
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.encoded64BaseImage = "no photo";
    }

    public Product(int pid,String name, double price){
        this.pid = pid;
        this.name = name;
        this.quantity = 1;
        this.price = price;
        this.encoded64BaseImage = "no photo";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEncoded64BaseImage() {
        return this.encoded64BaseImage;
    }

    public void setEncoded64BaseImage(String encoded64BaseImage){
        this.encoded64BaseImage = encoded64BaseImage;
    }

    public String encodeImage(String path){
        File file = new File(path);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            encodedfile = "File not found";
        } catch (IOException e) {
            encodedfile = "error";
        }
        return encodedfile;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }


    public int getPid() {
        return this.pid;
    }
}
