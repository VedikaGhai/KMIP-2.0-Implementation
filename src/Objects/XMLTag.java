package Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
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

    //@XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public EnumTag getTag() {
        return tag;
    }

    public void setTag(EnumTag tag) {
        this.tag = tag;
    }

    @XmlAttribute(name="type")
    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    @XmlAttribute(name="value")
    public KMIPType getValue() {
        return value;
    }

    public void setValue(KMIPType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XMLTag [name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value + "]";
    }

    
}