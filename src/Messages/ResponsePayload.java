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

/**
 * ResponsePayload POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 * @see SymmetricKey
 */ 
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

    /**
     * Parameterized constructor.
     * @param objectType the type of object which the user wants to manage, in the server. For eg. "SymmetricKey".
     * @param uniqueIdentifier the unique identifier of the objects the user wants to manage.
     * @param symmetricKey SymmetricKey object
     */
    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier, SymmetricKey symmetricKey) {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
        this.symmetricKey = symmetricKey;
    }
    
    /**
     * Default constructor.
     */
    public ResponsePayload()
    {
    }
    
    /**
     * Parameterized constructor.
     * @param objectType the type of object the user wants to manage.
     * @param uniqueIdentifier the unique identifier of the object the user wants to manage.
     */
    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier)
    {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * Getter.
     * @return XMLTag the object type
     */
    @XmlElement(name="ObjectType")
    public XMLTag getObjectType() {
        return objectType;
    }

    /**
     * Setter.
     * @param objectType
     */
    public void setObjectType(XMLTag objectType) {
        this.objectType = objectType;
    }

    /**
     * Getter.
     * @return XMLTag UniqueIdentifier
     */
    @XmlElement(name = "UniqueIdentifier")
    public XMLTag getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Setter.
     * @param uniqueIdentifier
     */
    public void setUniqueIdentifier(XMLTag uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * Getter.
     * @return SymmetricKey symmetric key object
     */
    public SymmetricKey getSymmetricKey() {
        return symmetricKey;
    }

    /**
     * Setter.
     * @param symmetricKey
     */
    public void setSymmetricKey(SymmetricKey symmetricKey) {
        this.symmetricKey = symmetricKey;
    }

    
}
