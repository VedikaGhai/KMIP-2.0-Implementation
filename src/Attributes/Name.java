package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement(name = "Name")
@XmlAccessorType(XmlAccessType.NONE)
public class Name
{
    XMLTag NameValue;
    XMLTag NameType;

    public Name(XMLTag nameValue, XMLTag nameType) {
        NameValue = nameValue;
        NameType = nameType;
    }

    @XmlElement(name = "NameValue")
    public XMLTag getNameValue() {
        return NameValue;
    }

    public void setNameValue(XMLTag nameValue) {
        NameValue = nameValue;
    }

    @XmlElement(name = "NameType")
    public XMLTag getNameType() {
        return NameType;
    }

    public void setNameType(XMLTag nameType) {
        NameType = nameType;
    }

    public Name() {
    }

    @Override
    public String toString() {
        return "Name [NameType=" + NameType + ", NameValue=" + NameValue + "]";
    }

}