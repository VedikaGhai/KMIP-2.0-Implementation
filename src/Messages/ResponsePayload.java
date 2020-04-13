package Messages;
//import Enum.EnumObjectType;
import Keys.SymmetricKey;
import Objects.XMLTag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import Attributes.*;

@XmlRootElement(name = "RequestPayload")
@XmlSeeAlso({Attribute.class, Name.class, XMLTag.class})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponsePayload {

    XMLTag objectType;
    XMLTag uniqueIdentifier;
    SymmetricKey symmetricKey;

    /* 3 constructors because there are 3 cases we encountered while looking at ResponsePayload in ResponseMessage
     1. There is nothing in the ResponsePayload
     2. There is only ObjectType and UniqueIdentifier in the ResponsePayload
     3. There are all 3 - ObjectType, UnqiueIdentifier and SymmetricKey in the ResponsePayload
    */

    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier, SymmetricKey symmetricKey) {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
        this.symmetricKey = symmetricKey;
    }
    
    public ResponsePayload()
    {
        //default constuctor
    }
    
    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier)
    {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
    }


    @XmlElement(name="ObjectType")
    public XMLTag getObjectType() {
        return objectType;
    }

    public void setObjectType(XMLTag objectType) {
        this.objectType = objectType;
    }

    @XmlElement(name = "UniqueIdentifier")
    public XMLTag getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(XMLTag uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public SymmetricKey getSymmetricKey() {
        return symmetricKey;
    }

    public void setSymmetricKey(SymmetricKey symmetricKey) {
        this.symmetricKey = symmetricKey;
    }

    
}
