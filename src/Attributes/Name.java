package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * Name POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */
@XmlRootElement(name = "Name")
@XmlAccessorType(XmlAccessType.NONE)
public class Name
{
    XMLTag NameValue;
    XMLTag NameType;

    /**
     * Parameterized constructor
     * @param nameValue
     * @param nameType
     */
    public Name(XMLTag nameValue, XMLTag nameType) {
        NameValue = nameValue;
        NameType = nameType;
    }

    /**
     * Getter
     * @return XMLTag Name value
     */
    @XmlElement(name = "NameValue")
    public XMLTag getNameValue() {
        return NameValue;
    }

    /**
     * Setter
     * @param nameValue
     */
    public void setNameValue(XMLTag nameValue) {
        NameValue = nameValue;
    }

    /**
     * Getter
     * @return XMLTag Name type
     */
    @XmlElement(name = "NameType")
    public XMLTag getNameType() {
        return NameType;
    }

    /**
     * Setter
     * @param nameType
     */
    public void setNameType(XMLTag nameType) {
        NameType = nameType;
    }

    /**
     * Default constructor
     */
    public Name() {
    }

    @Override
    public String toString() {
        return "Name [NameType=" + NameType + ", NameValue=" + NameValue + "]";
    }

}