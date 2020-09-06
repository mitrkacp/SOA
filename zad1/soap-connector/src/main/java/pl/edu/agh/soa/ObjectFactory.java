
package pl.edu.agh.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddVendor_QNAME = new QName("http://api.soa.agh.edu.pl/", "addVendor");
    private final static QName _AddVendorResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "addVendorResponse");
    private final static QName _DeleteVendor_QNAME = new QName("http://api.soa.agh.edu.pl/", "deleteVendor");
    private final static QName _DeleteVendorResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "deleteVendorResponse");
    private final static QName _GetAllVendors_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAllVendors");
    private final static QName _GetAllVendorsResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAllVendorsResponse");
    private final static QName _GetProductPhoto_QNAME = new QName("http://api.soa.agh.edu.pl/", "getProductPhoto");
    private final static QName _GetProductPhotoResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getProductPhotoResponse");
    private final static QName _GetVendorById_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorById");
    private final static QName _GetVendorByIdResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorByIdResponse");
    private final static QName _GetVendorProducts_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorProducts");
    private final static QName _GetVendorProductsResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorProductsResponse");
    private final static QName _GetVendorsByCountry_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorsByCountry");
    private final static QName _GetVendorsByCountryResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getVendorsByCountryResponse");
    private final static QName _SetProductPhoto_QNAME = new QName("http://api.soa.agh.edu.pl/", "setProductPhoto");
    private final static QName _SetProductPhotoResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "setProductPhotoResponse");
    private final static QName _UpdateVendor_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateVendor");
    private final static QName _UpdateVendorResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateVendorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetVendorsByCountryResponse }
     * 
     */
    public GetVendorsByCountryResponse createGetVendorsByCountryResponse() {
        return new GetVendorsByCountryResponse();
    }

    /**
     * Create an instance of {@link GetVendorProductsResponse }
     * 
     */
    public GetVendorProductsResponse createGetVendorProductsResponse() {
        return new GetVendorProductsResponse();
    }

    /**
     * Create an instance of {@link GetAllVendorsResponse }
     * 
     */
    public GetAllVendorsResponse createGetAllVendorsResponse() {
        return new GetAllVendorsResponse();
    }

    /**
     * Create an instance of {@link AddVendor }
     * 
     */
    public AddVendor createAddVendor() {
        return new AddVendor();
    }

    /**
     * Create an instance of {@link AddVendorResponse }
     * 
     */
    public AddVendorResponse createAddVendorResponse() {
        return new AddVendorResponse();
    }

    /**
     * Create an instance of {@link DeleteVendor }
     * 
     */
    public DeleteVendor createDeleteVendor() {
        return new DeleteVendor();
    }

    /**
     * Create an instance of {@link DeleteVendorResponse }
     * 
     */
    public DeleteVendorResponse createDeleteVendorResponse() {
        return new DeleteVendorResponse();
    }

    /**
     * Create an instance of {@link GetAllVendors }
     * 
     */
    public GetAllVendors createGetAllVendors() {
        return new GetAllVendors();
    }

    /**
     * Create an instance of {@link GetProductPhoto }
     * 
     */
    public GetProductPhoto createGetProductPhoto() {
        return new GetProductPhoto();
    }

    /**
     * Create an instance of {@link GetProductPhotoResponse }
     * 
     */
    public GetProductPhotoResponse createGetProductPhotoResponse() {
        return new GetProductPhotoResponse();
    }

    /**
     * Create an instance of {@link GetVendorById }
     * 
     */
    public GetVendorById createGetVendorById() {
        return new GetVendorById();
    }

    /**
     * Create an instance of {@link GetVendorByIdResponse }
     * 
     */
    public GetVendorByIdResponse createGetVendorByIdResponse() {
        return new GetVendorByIdResponse();
    }

    /**
     * Create an instance of {@link GetVendorProducts }
     * 
     */
    public GetVendorProducts createGetVendorProducts() {
        return new GetVendorProducts();
    }

    /**
     * Create an instance of {@link GetVendorsByCountry }
     * 
     */
    public GetVendorsByCountry createGetVendorsByCountry() {
        return new GetVendorsByCountry();
    }

    /**
     * Create an instance of {@link SetProductPhoto }
     * 
     */
    public SetProductPhoto createSetProductPhoto() {
        return new SetProductPhoto();
    }

    /**
     * Create an instance of {@link SetProductPhotoResponse }
     * 
     */
    public SetProductPhotoResponse createSetProductPhotoResponse() {
        return new SetProductPhotoResponse();
    }

    /**
     * Create an instance of {@link UpdateVendor }
     * 
     */
    public UpdateVendor createUpdateVendor() {
        return new UpdateVendor();
    }

    /**
     * Create an instance of {@link UpdateVendorResponse }
     * 
     */
    public UpdateVendorResponse createUpdateVendorResponse() {
        return new UpdateVendorResponse();
    }

    /**
     * Create an instance of {@link Vendor }
     * 
     */
    public Vendor createVendor() {
        return new Vendor();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link GetVendorsByCountryResponse.Vendors }
     * 
     */
    public GetVendorsByCountryResponse.Vendors createGetVendorsByCountryResponseVendors() {
        return new GetVendorsByCountryResponse.Vendors();
    }

    /**
     * Create an instance of {@link GetVendorProductsResponse.Products }
     * 
     */
    public GetVendorProductsResponse.Products createGetVendorProductsResponseProducts() {
        return new GetVendorProductsResponse.Products();
    }

    /**
     * Create an instance of {@link GetAllVendorsResponse.Vendors }
     * 
     */
    public GetAllVendorsResponse.Vendors createGetAllVendorsResponseVendors() {
        return new GetAllVendorsResponse.Vendors();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVendor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddVendor }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addVendor")
    public JAXBElement<AddVendor> createAddVendor(AddVendor value) {
        return new JAXBElement<AddVendor>(_AddVendor_QNAME, AddVendor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVendorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddVendorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addVendorResponse")
    public JAXBElement<AddVendorResponse> createAddVendorResponse(AddVendorResponse value) {
        return new JAXBElement<AddVendorResponse>(_AddVendorResponse_QNAME, AddVendorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteVendor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteVendor }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "deleteVendor")
    public JAXBElement<DeleteVendor> createDeleteVendor(DeleteVendor value) {
        return new JAXBElement<DeleteVendor>(_DeleteVendor_QNAME, DeleteVendor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteVendorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteVendorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "deleteVendorResponse")
    public JAXBElement<DeleteVendorResponse> createDeleteVendorResponse(DeleteVendorResponse value) {
        return new JAXBElement<DeleteVendorResponse>(_DeleteVendorResponse_QNAME, DeleteVendorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVendors }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllVendors }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAllVendors")
    public JAXBElement<GetAllVendors> createGetAllVendors(GetAllVendors value) {
        return new JAXBElement<GetAllVendors>(_GetAllVendors_QNAME, GetAllVendors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVendorsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllVendorsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAllVendorsResponse")
    public JAXBElement<GetAllVendorsResponse> createGetAllVendorsResponse(GetAllVendorsResponse value) {
        return new JAXBElement<GetAllVendorsResponse>(_GetAllVendorsResponse_QNAME, GetAllVendorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductPhoto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProductPhoto }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getProductPhoto")
    public JAXBElement<GetProductPhoto> createGetProductPhoto(GetProductPhoto value) {
        return new JAXBElement<GetProductPhoto>(_GetProductPhoto_QNAME, GetProductPhoto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductPhotoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProductPhotoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getProductPhotoResponse")
    public JAXBElement<GetProductPhotoResponse> createGetProductPhotoResponse(GetProductPhotoResponse value) {
        return new JAXBElement<GetProductPhotoResponse>(_GetProductPhotoResponse_QNAME, GetProductPhotoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorById }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorById")
    public JAXBElement<GetVendorById> createGetVendorById(GetVendorById value) {
        return new JAXBElement<GetVendorById>(_GetVendorById_QNAME, GetVendorById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorByIdResponse")
    public JAXBElement<GetVendorByIdResponse> createGetVendorByIdResponse(GetVendorByIdResponse value) {
        return new JAXBElement<GetVendorByIdResponse>(_GetVendorByIdResponse_QNAME, GetVendorByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorProducts }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorProducts }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorProducts")
    public JAXBElement<GetVendorProducts> createGetVendorProducts(GetVendorProducts value) {
        return new JAXBElement<GetVendorProducts>(_GetVendorProducts_QNAME, GetVendorProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorProductsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorProductsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorProductsResponse")
    public JAXBElement<GetVendorProductsResponse> createGetVendorProductsResponse(GetVendorProductsResponse value) {
        return new JAXBElement<GetVendorProductsResponse>(_GetVendorProductsResponse_QNAME, GetVendorProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorsByCountry }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorsByCountry }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorsByCountry")
    public JAXBElement<GetVendorsByCountry> createGetVendorsByCountry(GetVendorsByCountry value) {
        return new JAXBElement<GetVendorsByCountry>(_GetVendorsByCountry_QNAME, GetVendorsByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVendorsByCountryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetVendorsByCountryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getVendorsByCountryResponse")
    public JAXBElement<GetVendorsByCountryResponse> createGetVendorsByCountryResponse(GetVendorsByCountryResponse value) {
        return new JAXBElement<GetVendorsByCountryResponse>(_GetVendorsByCountryResponse_QNAME, GetVendorsByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetProductPhoto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetProductPhoto }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "setProductPhoto")
    public JAXBElement<SetProductPhoto> createSetProductPhoto(SetProductPhoto value) {
        return new JAXBElement<SetProductPhoto>(_SetProductPhoto_QNAME, SetProductPhoto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetProductPhotoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetProductPhotoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "setProductPhotoResponse")
    public JAXBElement<SetProductPhotoResponse> createSetProductPhotoResponse(SetProductPhotoResponse value) {
        return new JAXBElement<SetProductPhotoResponse>(_SetProductPhotoResponse_QNAME, SetProductPhotoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVendor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateVendor }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateVendor")
    public JAXBElement<UpdateVendor> createUpdateVendor(UpdateVendor value) {
        return new JAXBElement<UpdateVendor>(_UpdateVendor_QNAME, UpdateVendor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVendorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateVendorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateVendorResponse")
    public JAXBElement<UpdateVendorResponse> createUpdateVendorResponse(UpdateVendorResponse value) {
        return new JAXBElement<UpdateVendorResponse>(_UpdateVendorResponse_QNAME, UpdateVendorResponse.class, null, value);
    }

}
