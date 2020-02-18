package Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;

//@XmlRegistry
@XmlRootElement
//@XmlAccessorType(XmlAccessType.NONE)
public class XMLTag
{
    String name;
    EnumTag tag;

    EnumType type;
    KMIPType value;

    public XMLTag(){

    }

    public XMLTag(String name, EnumTag tag, EnumType type, KMIPType value) {
        this.name = name;
        this.tag = tag;
        this.type = type;
        this.value = value;
    }

    public XMLTag(String name, EnumType type, KMIPType value) {
        this.name = name;
        //this.tag = tag;
        this.type = type;
        this.value = value;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlTransient
    public EnumTag getTag() {
        return tag;
    }

    public void setTag(EnumTag tag) {
        this.tag = tag;
    }

    //@XmlTransient
    //@XmlElementDecl(scope = EnumType.class, name="type")

    @XmlAttribute(name = "type")
    public String getType() {
        return type.getType();
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    //@XmlTransient
    //@XmlElementDecl(scope = KMIPType.class, name = "value")
    @XmlAttribute(name = "value")
    public String getValue() {
        return value.getValue();
    }

    public void setValue(KMIPType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XMLTag [name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value + "]";
    }

    
}