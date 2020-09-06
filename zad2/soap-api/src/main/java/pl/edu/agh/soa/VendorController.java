package pl.edu.agh.soa;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.model.Product;
import pl.edu.agh.soa.model.Vendor;
import pl.edu.agh.soa.model.VendorList;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService
@SecurityDomain("test-security-domain")
@DeclareRoles({"GrupaTestowa"})
@WebContext(contextRoot="/SOA-1", urlPattern="/VendorController", authMethod="BASIC",transportGuarantee="NONE",
        secureWSDLAccess = false)
public class VendorController {

    private VendorList vendors = VendorList.createSampleList();

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "vendors")
    @XmlElement(name = "vendor")
    public List<Vendor> getAllVendors() {
        return vendors.getVendors();
    }

    @WebMethod
    @PermitAll
    @XmlElement(name = "vendor")
    public Vendor getVendorById(@WebParam(name = "id") int id) {
        return vendors.getVendorById(id);
    }

    @WebMethod
    @PermitAll
    public void setProductPhoto(@WebParam(name = "id") int id, @WebParam(name = "pid") int pid, @WebParam(name =
            "encoded64BaseImage") String encoded64BaseImage) {
        Vendor vendor = vendors.getVendorById(id);
        if(vendor != null){
            vendor.getProductByPid(pid).setEncoded64BaseImage(encoded64BaseImage);
        }
    }

    @WebMethod
    @PermitAll
    @XmlElement(name = "encoded64BaseImage")
    public String getProductPhoto(@WebParam(name = "id") int id, @WebParam(name = "pid") int pid) {
        Vendor vendor = vendors.getVendorById(id);
        if(vendor != null){
            return vendor.getProductByPid(pid).getEncoded64BaseImage();
        }
        return null;
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "vendors")
    @XmlElement(name = "vendor")
    public List<Vendor> getVendorsByCountry(@WebParam(name = "country") String country) {
        return vendors.getVendorsByCountry(country);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public List<Product> getVendorProducts(@WebParam(name = "id") int id) {
        Vendor vendor = vendors.getVendorById(id);
        if(vendor != null){
           return vendor.getProducts();
        }
        return null;
    }

    @RolesAllowed("GrupaTestowa")
    @WebMethod(action = "addVendor")
    @XmlElement(name = "vendor")
    public Vendor addVendor(@WebParam(name = "firstName") String firstName,
                            @WebParam(name = "lastName") String lastName,
                            @WebParam(name = "nickname") String nickname, @WebParam(name = "id") int id,
                            @WebParam(name = "country") String country){
        Vendor newVendor = null;
        if(vendors.getVendorById(id) == null) {
            newVendor = new Vendor(firstName, lastName, nickname, id, country);
            vendors.addVendor(newVendor);
        }
        return newVendor;
    }

    @RolesAllowed("GrupaTestowa")
    @WebMethod(action = "deleteVendor")
    @XmlElement(name = "vendor")
    public boolean deleteVendor(@WebParam(name = "id") int id){
        return vendors.deleteVendor(id);
    }

    @RolesAllowed("GrupaTestowa")
    @WebMethod(action = "updateVendor")
    @XmlElement(name = "vendor")
    public Vendor updateVendor(@WebParam(name = "firstName") String firstName,
                                @WebParam(name = "lastName") String lastName,
                                @WebParam(name = "nickname") String nickname, @WebParam(name = "id") int id,
                                @WebParam(name = "country") String country){
        Vendor vendor = vendors.getVendorById(id);
        if(vendor == null) {
            return vendor;
        }
        vendor.setFirstName(firstName);
        vendor.setLastName(lastName);
        vendor.setNickname(nickname);
        vendor.setId(id);
        vendor.setCountry(country);

        return vendor;
    }


}
