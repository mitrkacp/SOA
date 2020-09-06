package pl.edu.agh.soa.api;


import io.swagger.annotations.*;
import pl.edu.agh.soa.JWT.JWTTokenNeeded;
import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;
import pl.edu.agh.soa.model.VendorList;
import pl.edu.agh.soa.model.VendorProtobuf;
import pl.edu.agh.soa.*;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Base64;

@Api(value = "vendorApi")
@Path("/vendors")
public class Controller {

    static VendorList vendors = VendorList.createSampleList();

    @EJB
    private VendorDao vendorDao = new VendorDao();

    @EJB
    private ProductDao productDao = new ProductDao();


    @GET
    @Path("/")
    @ApiOperation(value = "getVendors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVendors(@QueryParam("id") int id,
                                  @QueryParam("firstName") String firstName,
                                  @QueryParam("lastName") String lastName,
                                  @QueryParam("nickName") String nickname,
                                  @QueryParam("country") String country
                                  ) {

//        List<Vendor> vendorList = vendors.getVendors();
        List<Vendor> vendorList = vendorDao.getAllVendors();

        if (vendorList == null || vendorList.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("No vendors in database").build();
        }

        if(id != 0){
//            Vendor vendor = vendors.getVendorById(id);
            Vendor vendor = null;
            try{
                vendor = vendorDao.findVendorById(id);
            }catch (Exception e){
                return Response.status(Response.Status.NOT_FOUND).entity("Vendor with this id not found").build();
            }
            return Response.status(Response.Status.OK).entity(vendor).build();
        }


        return Response.status(Response.Status.OK).entity(vendorList).build();
    }

    @GET
    @Path("/{vendorID}")
    @ApiOperation(value = "getVendor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVendorById(@PathParam("vendorID") int vendorID) {
        Vendor vendor;

        try{
            vendor = vendorDao.findVendorById(vendorID);
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Methods", "GET").build();
        }

        return Response.ok().entity(vendor).status(Response.Status.OK).entity(vendor).build();
    }

    @PUT
    @Path("/{vendorID}/{productID}/photo")
    @ApiOperation(value = "setProductPhoto")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTTokenNeeded
    public Response setProductPhoto(@PathParam("vendorID") int vendorID , @PathParam("productID") int productID , @ApiParam(required=true) @QueryParam("photo") String photoBase64) {

        Vendor vendor = new Vendor();
        Product product = new Product();

        try{
            vendor = vendorDao.findVendorById(vendorID);
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity("Vendor not found").build();
        }

        try{
            product = productDao.findProductById(productID);
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }

        product.setEncoded64BaseImage(photoBase64);

        try{
            productDao.update(product);
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }

        return Response.status(Response.Status.OK).entity(product).build();
    }

    @GET
    @Path("/{vendorID}/{productID}/photo")
    @Produces("image/jpeg")
    @ApiOperation(value = "getProductPhoto", response = byte.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product photo"),
            @ApiResponse(code = 403, message = "Product has no photo"),
            @ApiResponse(code = 404, message = "Product not found")})
    public Response getProductPhoto(@PathParam("vendorID") int vendorID , @PathParam("productID") int productID) {

        Vendor vendor = vendors.getVendorById(vendorID);

        byte[] imageBytes = Base64.getDecoder().decode(vendor.getProductByPid(productID).getEncoded64BaseImage());
        if(vendor!=null){
            if(!vendor.getProductByPid(productID).getEncoded64BaseImage().equals("")) {
                return Response.status(Response.Status.OK).entity(imageBytes).build();
            }
            return Response.status(Response.Status.FORBIDDEN).entity("Product has no photo").build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Vendor not found").build();

    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "addVendor", response = Vendor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Vendor added", response = Vendor.class),
            @ApiResponse(code = 409, message = "Vendor already exists")})
    //@JWTTokenNeeded
    public Response addVendor(Vendor vendor) {

        Response response = getVendorById(vendor.getId());
        if (response.getStatus() == 404) {
//            vendors.addVendor(vendor);
            vendorDao.save(vendor);
            return Response.status(Response.Status.CREATED).entity(vendor).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("Vendor already exists").build();
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

    @GET
    @Produces("application/protobuf")
    @Path("/{id}/protobuf")
    @ApiOperation("Get Vendor by ID - Protobuf")
    public Response getVendorByIdProtobuf(@ApiParam(required = true) @PathParam("id") int ID) {

        var vendorBuilder = VendorProtobuf.Vendor.newBuilder();
        if (vendors.getVendorById(ID) != null) {
            Vendor vendor = vendors.getVendorById(ID);

            vendorBuilder.setId(vendor.getId()).setFirstName(vendor.getFirstName()).setLastName(vendor.getLastName());
            var newVendor = vendorBuilder.build();
            return Response.status(Response.Status.OK).entity(newVendor).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{vendorID}/nickname")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Change vendor nickname")
    @JWTTokenNeeded
    public Response updateVendorNickname(@PathParam("vendorID") int vendorID, @ApiParam(required = true, name = "nickname") @QueryParam("nickname") String newNickname) {

        Vendor vendor = new Vendor();

        try {
            vendor = vendorDao.findVendorById(vendorID);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("vendor not found").build();
        }
        vendor.setNickname(newNickname);
        try {
            vendorDao.update(vendor);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("vendor not found").build();
        }
        return Response.status(Response.Status.OK).entity(vendor).build();
    }

    @GET
    @Path("/adddata/mockdata")
    public Response addvendors() {

        vendorDao.save(vendors.getVendorById(1));
        vendorDao.save(vendors.getVendorById(2));
        vendorDao.save(vendors.getVendorById(3));



        return Response.status(Response.Status.OK).entity("Data added to database").build();
    }

}

