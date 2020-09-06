


import pl.edu.agh.soa.Product;
import pl.edu.agh.soa.Vendor;
import pl.edu.agh.soa.VendorController;
import pl.edu.agh.soa.VendorControllerService;

import javax.xml.ws.BindingProvider;
import java.io.*;
import java.util.Base64;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        VendorControllerService vendorControllerService = new VendorControllerService();
        VendorController vendorController = vendorControllerService.getVendorControllerPort();

        Map<String, Object> reqContext = ((BindingProvider)
                vendorController).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, "jacek");
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, "placek");

        System.out.println("befor nickname update: "+vendorController.getVendorById(3).getNickname());
        vendorController.updateVendor("Janusz","Kozak","janoosh777",3,"Poland");
        System.out.println("after nickname update: "+vendorController.getVendorById(3).getNickname()+"\n\n");

        //wypisanie vendorow i ich produktow
        for (Vendor vendor : vendorController.getAllVendors().getVendor()) {
            System.out.println("-----------VENDOR----------------");
            System.out.println("firstName: " + vendor.getFirstName());
            System.out.println("lastName: " + vendor.getLastName());
            System.out.println("nickname: " + vendor.getNickname());
            System.out.println("ID: " + vendor.getId());
            System.out.println("country: " + vendor.getCountry());
            System.out.println("------------PRODUCTS------------------");
            for(Product product: vendor.getProducts()){
                System.out.println("product name: "+product.getName());
                System.out.println("price: "+product.getPrice());
                System.out.println("quantity: "+product.getQuantity());
                System.out.println("------------------------------------");
            }
        }

        //ustawienie zdjecia produktowi o pid==5 sprzedawanym przez vendora o id==3 pobierajac je ze ścieżki
        // soap-connector/src/main/resources/images/image1.jpg i kodując je, następnie pobranie tego zdjęcia z
        // serwera w
        // zakodowanej formie,
        // odkodowanie oraz
        // zapisanie pliku jpg w
        // soap-connector/src/main/resources/images/receivedFromServer.jpg
        if (vendorController.getVendorById(3) != null) {

            vendorController.setProductPhoto(3,5,encodeImage("soap-connector/src/main/resources/images/image1.jpg"));
            decodeImage(vendorController.getProductPhoto(3,5));
            //System.out.println(encodeImage("soap-connector/src/main/java/images/image1.jpg"));
            //System.out.println(vendorController.getProductPhoto(3,5));

        }
    }

    public static String encodeImage(String pathToPhoto) {

        File file = new File(pathToPhoto);
        String encodedfile;
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
        //System.out.println(encodedfile);
        return encodedfile;
    }

    public static void decodeImage(String ImageBase64) {
        File file = new File("soap-connector/src/main/resources/images/receivedFromServer.jpg");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);) {
            byte[] decoder = Base64.getDecoder().decode(ImageBase64);
            fileOutputStream.write(decoder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
