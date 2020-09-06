import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;
import pl.edu.agh.soa.model.VendorProtobuf;
import protobuf.MessageWriter;

import javax.swing.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class RestClient {
    private ResteasyClient resteasyClient;
    private static String token = null;

    public static void main(String[] args) {

        RestClient client = new RestClient("admin", "admin");

        //wypisanie vendorow i ich produktow
        for (Vendor vendor : client.getAllVendors()) {
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
        //dodanie vendora i jego produktow
        Vendor vendor = new Vendor("Andrzej","Nowacki","endriu228",4, "Poland");
        vendor.addProduct(new Product(6,"Chain saw", 1200.0, 1));
        vendor.addProduct(new Product(7,"Coffee cup", 6.0, 3));

        client.addVendor(vendor);

        //szukanie vendora po id
        System.out.println(client.getVendorById(4));

        //dodanie zdjęcia dla produktu
        System.out.println("\nSet photo");
        client.setPhoto(3,5, encodeImage("rest-connector/src/main/resources/images/image1.jpg"));

        //pobranie zdjecia produktu
        System.out.println("Get photo");
        client.getPhoto(3, 5);

        //protobuf
        System.out.println("\n Get vendor by id using Protobuf");
        System.out.println(client.tryGetVendorByIdProtobuf(1));

        client.resteasyClient.close();

    }

    public RestClient() {
        this.resteasyClient = new ResteasyClientBuilder().build();
    }

    public RestClient(String username, String password) {
        this.resteasyClient = new ResteasyClientBuilder().build();

        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app//authorization/login");

        Form form = new Form();
        form.param("login", username);
        form.param("password", password);
        Response response = resteasyWebTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        MultivaluedMap<String, String> headers = response.getStringHeaders();
        token = headers.getFirst("authorization");


    }

    private List<Vendor> getAllVendors() {
        List<Vendor> result = new ArrayList<>();
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app/vendors");

        Response response = resteasyWebTarget.request().get();
        int responseStatus = response.getStatus();
        if (responseStatus == 200) {
            result = response.readEntity(new GenericType<List<Vendor>>() {
            });
        }
        response.close();
        return result;
    }



    private void addVendor(Vendor vendor) {
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app/vendors/add");
        Response response = resteasyWebTarget.request().header("authorization", token).post(Entity.entity(vendor, MediaType.APPLICATION_JSON_TYPE));
        if (response.getStatus() == 201) {
            System.out.println("Vendor successfully added to database\n");
        } else {
            System.out.println("Vendor already exists in database\n");
        }
        response.close();

    }

    private Vendor getVendorById(int ID) {
        Vendor vendor = null;
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app/vendors/" + ID);
        Response response = resteasyWebTarget.request().get();
        if (response.getStatus() == 200) {
            vendor = response.readEntity(Vendor.class);
            return vendor;
        }
        return vendor;
    }

    private void setPhoto(int ID, int PID, String photoInBase64) {

        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app/vendors/" + ID + "/"  + PID +"/photo")
                .queryParam("photo", photoInBase64);

        Response response = resteasyWebTarget.request().header("Authorization", token).put(null);
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) {
            System.out.println("Photo set\n");
        } else {
            System.out.println("Error\n");
        }
        response.close();

    }


    private void getPhoto(int ID, int PID) {
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target("http://localhost:8080/rest-api/app/vendors/" + ID + "/"  + PID + "/photo");

        Response response = resteasyWebTarget.request().get();
        byte[] photo = response.readEntity(byte[].class);

        if (response.getStatus() == 200) {
            decodeImage(photo);
            System.out.println("Photo downloaded");
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
        System.out.println(encodedfile);
        return encodedfile;
    }

    public static void decodeImage(byte[] Image) {
        File file = new File("rest-connector/src/main/resources/images/receivedFromServer.jpg");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);) {
            byte[] decoder = Image;
            fileOutputStream.write(decoder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // protobuf
    private VendorProtobuf.Vendor tryGetVendorByIdProtobuf(int id){
        VendorProtobuf.Vendor vendor = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/app/vendors/"+id+"/protobuf").register(MessageWriter.class);
        Response response = target.request().get();

        if(response.getStatus() == 200) {
            vendor = response.readEntity(VendorProtobuf.Vendor.class);
        }

        response.close();

        return vendor;
    }

}
