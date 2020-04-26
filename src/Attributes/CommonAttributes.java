package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * CommonAttributes POJO class. 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */
@XmlRootElement(name = "CommonAttributes")
@XmlAccessorType(XmlAccessType.NONE)
public class CommonAttributes 
{
    XMLTag CryptographicAlgorithm;
    XMLTag CryptographicLength;

    /**
     * Default constructor
     */
    public CommonAttributes() {
    }

    /**
     * Getter
     * @return XMLTag cryptographic algorithm
     */
    @XmlElement(name="CryptographicAlgorithm")
    public XMLTag getCryptographicAlgorithm() {
        return CryptographicAlgorithm;
    }

    /**
     * Setter
     * @param cryptographicAlgorithm Cryptographic algorithm
     */
    public void setCryptographicAlgorithm(XMLTag cryptographicAlgorithm) {
        CryptographicAlgorithm = cryptographicAlgorithm;
    }

    /**
     * Getter
     * @return XMLTag cryptographic length
     */
    @XmlElement(name="CryptographicLength")
    public XMLTag getCryptographicLength() {
        return CryptographicLength;
    }

    /**
     * Setter
     * @param cryptographicLength cryptographic length
     */
    public void setCryptographicLength(XMLTag cryptographicLength) {
        CryptographicLength = cryptographicLength;
    }

    /**
     * Parameterized constructor
     * @param cryptographicAlgorithm cryptographic algorithm
     * @param cryptographicLength cryptographic length
     */
    public CommonAttributes(XMLTag cryptographicAlgorithm, XMLTag cryptographicLength) {
        CryptographicAlgorithm = cryptographicAlgorithm;
        CryptographicLength = cryptographicLength;
    }    

}