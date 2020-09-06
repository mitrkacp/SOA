
package pl.edu.agh.soa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProductPhotoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProductPhotoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="encoded64BaseImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductPhotoResponse", propOrder = {
    "encoded64BaseImage"
})
public class GetProductPhotoResponse {

    protected String encoded64BaseImage;

    /**
     * Gets the value of the encoded64BaseImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoded64BaseImage() {
        return encoded64BaseImage;
    }

    /**
     * Sets the value of the encoded64BaseImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoded64BaseImage(String value) {
        this.encoded64BaseImage = value;
    }

}
