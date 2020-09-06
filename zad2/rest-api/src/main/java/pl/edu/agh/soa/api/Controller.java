package pl.edu.agh.soa.api;


import io.swagger.annotations.*;
import pl.edu.agh.soa.JWT.JWTTokenNeeded;
import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;
import pl.edu.agh.soa.model.VendorList;
import pl.edu.agh.soa.model.VendorProtobuf;

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

        List<Vendor> vendorList = vendors.getVendors();

        if (vendorList == null || vendorList.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("No vendors in database").build();
        }

        if(id != 0){
            Vendor vendor = vendors.getVendorById(id);
            return Response.status(Response.Status.OK).entity(vendor).build();
        }


        return Response.status(Response.Status.OK).entity(vendorList).build();
    }

    @GET
    @Path("/{vendorID}")
    @ApiOperation(value = "getVendor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVendorById(@PathParam("vendorID") int vendorID) {
        Vendor vendor = vendors.getVendorById(vendorID);

        if(vendor!=null){
            return Response.status(Response.Status.OK).entity(vendor).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Vendor not found").build();
    }

    @PUT
    @Path("/{vendorID}/{productID}/photo")
    @ApiOperation(value = "setProductPhoto")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response setProductPhoto(@PathParam("vendorID") int vendorID , @PathParam("productID") int productID , @ApiParam(required=true) @QueryParam("photo") String photoBase64) {

        List<Vendor> vendorList = vendors.getVendors();

        for (Vendor vendor : vendorList) {
            if (vendor.getId() == vendorID) {
                vendor.getProductByPid(productID).setEncoded64BaseImage(photoBase64);
                return Response.status(Response.Status.OK).entity(vendor).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
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
    @JWTTokenNeeded
    public Response addVendor(Vendor vendor) {

        Response response = getVendorById(vendor.getId());
        if (response.getStatus() == 404) {
            vendors.addVendor(vendor);
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
}

