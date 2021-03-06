
package pl.edu.agh.soa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VendorController", targetNamespace = "http://api.soa.agh.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VendorController {


    /**
     * 
     * @param country
     * @return
     *     returns pl.edu.agh.soa.GetVendorsByCountryResponse.Vendors
     */
    @WebMethod
    @WebResult(name = "vendors", targetNamespace = "")
    @RequestWrapper(localName = "getVendorsByCountry", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorsByCountry")
    @ResponseWrapper(localName = "getVendorsByCountryResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorsByCountryResponse")
    public pl.edu.agh.soa.GetVendorsByCountryResponse.Vendors getVendorsByCountry(
        @WebParam(name = "country", targetNamespace = "")
        String country);

    /**
     * 
     * @param id
     * @return
     *     returns pl.edu.agh.soa.GetVendorProductsResponse.Products
     */
    @WebMethod
    @WebResult(name = "products", targetNamespace = "")
    @RequestWrapper(localName = "getVendorProducts", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorProducts")
    @ResponseWrapper(localName = "getVendorProductsResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorProductsResponse")
    public pl.edu.agh.soa.GetVendorProductsResponse.Products getVendorProducts(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns pl.edu.agh.soa.GetAllVendorsResponse.Vendors
     */
    @WebMethod
    @WebResult(name = "vendors", targetNamespace = "")
    @RequestWrapper(localName = "getAllVendors", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetAllVendors")
    @ResponseWrapper(localName = "getAllVendorsResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetAllVendorsResponse")
    public pl.edu.agh.soa.GetAllVendorsResponse.Vendors getAllVendors();

    /**
     * 
     * @param firstName
     * @param lastName
     * @param country
     * @param nickname
     * @param id
     * @return
     *     returns pl.edu.agh.soa.Vendor
     */
    @WebMethod(action = "addVendor")
    @WebResult(name = "vendor", targetNamespace = "")
    @RequestWrapper(localName = "addVendor", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddVendor")
    @ResponseWrapper(localName = "addVendorResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddVendorResponse")
    public Vendor addVendor(
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName,
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname,
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "country", targetNamespace = "")
        String country);

    /**
     * 
     * @param firstName
     * @param lastName
     * @param country
     * @param nickname
     * @param id
     * @return
     *     returns pl.edu.agh.soa.Vendor
     */
    @WebMethod(action = "updateVendor")
    @WebResult(name = "vendor", targetNamespace = "")
    @RequestWrapper(localName = "updateVendor", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.UpdateVendor")
    @ResponseWrapper(localName = "updateVendorResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.UpdateVendorResponse")
    public Vendor updateVendor(
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName,
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname,
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "country", targetNamespace = "")
        String country);

    /**
     * 
     * @param encoded64BaseImage
     * @param pid
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "setProductPhoto", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.SetProductPhoto")
    @ResponseWrapper(localName = "setProductPhotoResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.SetProductPhotoResponse")
    public void setProductPhoto(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "pid", targetNamespace = "")
        int pid,
        @WebParam(name = "encoded64BaseImage", targetNamespace = "")
        String encoded64BaseImage);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod(action = "deleteVendor")
    @WebResult(name = "vendor", targetNamespace = "")
    @RequestWrapper(localName = "deleteVendor", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.DeleteVendor")
    @ResponseWrapper(localName = "deleteVendorResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.DeleteVendorResponse")
    public boolean deleteVendor(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param pid
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "encoded64BaseImage", targetNamespace = "")
    @RequestWrapper(localName = "getProductPhoto", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetProductPhoto")
    @ResponseWrapper(localName = "getProductPhotoResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetProductPhotoResponse")
    public String getProductPhoto(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "pid", targetNamespace = "")
        int pid);

    /**
     * 
     * @param id
     * @return
     *     returns pl.edu.agh.soa.Vendor
     */
    @WebMethod
    @WebResult(name = "vendor", targetNamespace = "")
    @RequestWrapper(localName = "getVendorById", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorById")
    @ResponseWrapper(localName = "getVendorByIdResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetVendorByIdResponse")
    public Vendor getVendorById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

}
