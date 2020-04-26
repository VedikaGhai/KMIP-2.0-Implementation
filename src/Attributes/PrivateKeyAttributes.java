package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * PrivateKeyAttributes POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see Name
 * @see XMLTag
 */
@XmlRootElement(name="PrivateKeyAttributes")
@XmlAccessorType(XmlAccessType.NONE)
public class PrivateKeyAttributes
{
    Name name;
    XMLTag CryptographicUsageMask;

    /**
     * Default constructor
     */
    public PrivateKeyAttributes() {
    }

    /**
     * Parameterized constructor
     * @param name object of type Name
     * @param cryptographicUsageMask
     */
    public PrivateKeyAttributes(Name name, XMLTag cryptographicUsageMask) {
        this.name = name;
        CryptographicUsageMask = cryptographicUsageMask;
    }

    /**
     * Getter
     * @return Name object of type name
     */
    @XmlElement(name="Name")
    public Name getName() {
        return name;
    }

    /**
     * Setter
     * @param name object of type Name
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