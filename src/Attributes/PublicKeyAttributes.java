package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * PublicKeyAttributes POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 */
@XmlRootElement(name="PublicKeyAttributes")
@XmlAccessorType(XmlAccessType.NONE)
public class PublicKeyAttributes
{
    Name name;
    XMLTag CryptographicUsageMask;

    /**
     * Default constructor
     */
    public PublicKeyAttributes() {
    }

    /**
     * Parameterized constructor.
     * @param name
     * @param cryptographicUsageMask
     */
    public PublicKeyAttributes(Name name, XMLTag cryptographicUsageMask) {
        this.name = name;
        CryptographicUsageMask = cryptographicUsageMask;
    }

    /**
     * Getter
     * @return Name name
     */
    @XmlElement(name="Name")
    public Name getName() {
        return name;
    }

    /**
     * Setter
     * @param name 
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Getter
     * @return XMLTag CryptographicUsageMask
     */
    @XmlElement(name="CryptographicUsageMask")
    public XMLTag getCryptographicUsageMask() {
        return CryptographicUsageMask;
    }

    /**
     * Setter
     * @param cryptographicUsageMask
     */
    public void setCryptographicUsageMask(XMLTag cryptographicUsageMask) {
        CryptographicUsageMask = cryptographicUsageMask;
    }

}