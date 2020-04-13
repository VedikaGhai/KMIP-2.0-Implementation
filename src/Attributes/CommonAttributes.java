package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement(name = "CommonAttributes")
@XmlAccessorType(XmlAccessType.NONE)
public class CommonAttributes 
{
    XMLTag CryptographicAlgorithm;
    XMLTag CryptographicLength;

    public CommonAttributes() {
    }

    @XmlElement(name="CryptographicAlgorithm")
    public XMLTag getCryptographicAlgorithm() {
        return CryptographicAlgorithm;
    }

    public void setCryptographicAlgorithm(XMLTag cryptographicAlgorithm) {
        CryptographicAlgorithm = cryptographicAlgorithm;
    }

    @XmlElement(name="CryptographicLength")
    public XMLTag getCryptographicLength() {
        return CryptographicLength;
    }

    public void setCryptographicLength(XMLTag cryptographicLength) {
        CryptographicLength = cryptographicLength;
    }

    public CommonAttributes(XMLTag cryptographicAlgorithm, XMLTag cryptographicLength) {
        CryptographicAlgorithm = cryptographicAlgorithm;
        CryptographicLength = cryptographicLength;
    }    

}