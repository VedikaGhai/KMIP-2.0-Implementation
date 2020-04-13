package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement(name="PublicKeyAttributes")
@XmlAccessorType(XmlAccessType.NONE)
public class PublicKeyAttributes
{
    Name name;
    XMLTag CryptographicUsageMask;

    public PublicKeyAttributes() {
    }

    public PublicKeyAttributes(Name name, XMLTag cryptographicUsageMask) {
        this.name = name;
        CryptographicUsageMask = cryptographicUsageMask;
    }

    @XmlElement(name="Name")
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @XmlElement(name="CryptographicUsageMask")
    public XMLTag getCryptographicUsageMask() {
        return CryptographicUsageMask;
    }

    public void setCryptographicUsageMask(XMLTag cryptographicUsageMask) {
        CryptographicUsageMask = cryptographicUsageMask;
    }

}