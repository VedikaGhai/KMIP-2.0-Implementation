package Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.bind.annotation.*;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;

/**
 * XMLTag POJO class.
 * This is the generic class for all tags, specifying methods
 * to initialize name, type, tag, value for them.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see EnumTag
 * @see EnumType
 * @see KMIPType
 */ 
@XmlRootElement
public class XMLTag
{
    String name;
    EnumTag tag;

    EnumType type;
    KMIPType value;

    /**
     * Default constructor.
     */
    public XMLTag(){

    }

    /**
     * Parameterized constructor.
     * @param name name of the attribute. For eg. "CryptographicAlgorithm".
     * @param tag Enumerated value of the attribute. 
     * @param type data type as interpreted by KMIP, of the attribute. 
     * @param value value of the attribute. For eg. CryptographicAlgorithm will be of type KMIPTextString.
     */
    public XMLTag(String name, EnumTag tag, EnumType type, KMIPType value) {
        this.name = name;
        this.tag = tag;
        this.type = type;
        this.value = value;
    }

    /**
     * Parameterized constructor.
     * @param name name of the attribute. For eg. "CryptographicAlgorithm".
     * @param type data type as interpreted by KMIP, of the attribute. 
     * @param value value of the attribute. For eg. CryptographicAlgorithm will be of type KMIPTextString.
     */
    public XMLTag(String name, EnumType type, KMIPType value) {
        this.name = name;
        //this.tag = tag;
        this.type = type;
        this.value = value;
    }

    /**
     * Getter.
     * @return String name of the attribute.
     */
    @XmlTransient
    public String getName() {
        return name;
    }

    /**
     * Setter.
     * @param name name of the attribute.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter.
     * @return EnumTag tag of the attribute.
     */
    @XmlTransient
    public EnumTag getTag() {
        return tag;
    }

    /**
     * Setter.
     * @param tag Enumerated value of the attribute.
     */
    public void setTag(EnumTag tag) {
        this.tag = tag;
    }

    /**
     * Getter.
     * @return String data type of the attribute.
     */
    @XmlAttribute(name = "type")
    public String getType() {
        return type.getType();
    }

    /**
     * Setter.
     * @param type data type of the attribute, as interpreted by KMIP.
     */
    public void setType(EnumType type) {
        this.type = type;
    }

    /**
     * Getter.
     * @return String value of the attribute.
     */
    @XmlAttribute(name = "value")
    public String getValue() {
        return value.getValue();
    }

    /**
     * Setter.
     * @param value value of the attribute.
     */
    public void setValue(KMIPType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XMLTag [name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value + "]";
    }

    
}