package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import Attributes.*;
import Objects.XMLTag;

/**
 * RequestPayload POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag 
 * @see CommonAttributes
 * @see PrivateKeyAttributes
 * @see PublicKeyAttributes 
 */ 
@XmlRootElement(name = "RequestPayload")
@XmlSeeAlso({Attribute.class, Name.class, XMLTag.class})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestPayload {
	
	XMLTag objectType;
	XMLTag UniqueIdentifier;
	XMLTag KeyFormatType;

	CommonAttributes commonAttributes;
	PrivateKeyAttributes privateKeyAttributes;
	PublicKeyAttributes publicKeyAttributes;

	//@XmlElementWrapper(name = "Attributes")
	//@XmlElement(name="Attribute")
	//@XmlElement(name = "Attributes")
	//@XmlElementRef
	//@XmlVariableNode("name")

	//trial
	List<JAXBElement<Object>> attributes;


	//original --> List<Object> attributes;

	/**
	 * Default constructor.
	 */
	public RequestPayload(){
		
	}

	/**
	 * Parameterized constructor.
	 * @param objectType object type to be accessed/managed on the server. for eg. "SymmetricKey".
	 * @param attributes information regarding the object, for eg. "VendorIdentificationNumber".
	 */
	public RequestPayload(XMLTag objectType, List<JAXBElement<Object>> attributes) {
		this.attributes =  new ArrayList<JAXBElement<Object>>();
		this.objectType = objectType;
		this.attributes = attributes;
	}

	/**
	 * Getter.
	 * @return XMLTag Object type
	 */
	@XmlElement(name = "ObjectType")
	public XMLTag getObjectType() {
		return objectType;
	}

	/**
	 * Setter.
	 * @param objectType object type of the object to be accessed/managed on the server. For eg. "SymmetricKey".
	 */
	public void setObjectType(XMLTag objectType) {
		this.objectType = objectType;
	}
	
	/*
	@XmlElements({
		@XmlElement(type=Attribute.class)
		@XmlElement(type = XMLTag.class)
	})*/
	//@XmlElementRef()
	//@XmlAnyElement(lax = true)
	//@XmlElement(name = "Attribute")

	/* original -->
	@XmlElementWrapper(name= "Attributes")
	
	@XmlElements({
		@XmlElement(name="Attribute", type=Attribute.class),
		@XmlElement(name="CryptographicAlgorithm", type=XMLTag.class),
		@XmlElement(name="CryptographicLength", type=XMLTag.class),
		@XmlElement(name= "CryptographicUsageMask",type=XMLTag.class)
	})*/
	
	/**
	 * Parameterized constructor.
	 * @return {@code List<JAXBElement<Object>>} list of attributes (of the object) of different types.
	 */
	@XmlElementWrapper(name = "Attributes")
	@XmlAnyElement
	public List<JAXBElement<Object>> getAttributes() {
		return attributes;
	}

	/**
	 * Setter.
	 * @param attributes information regarding the object, for eg. "VendorIdentificationNumber".
	 */
	public void setAttributes(List<JAXBElement<Object>> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "RequestPayload [attributes=" + attributes + ", objectType=" + objectType + "]";
	}

	/**
	 * Getter.
	 * @return XMLTag unique identifier of the object on the server.
	 */
	@XmlElement(name="UniqueIdentifier")
	public XMLTag getUniqueIdentifier() {
		return UniqueIdentifier;
	}

	/**
	 * Setter.
	 * @param uniqueIdentifier unique identifier of the object on the server.
	 */
	public void setUniqueIdentifier(XMLTag uniqueIdentifier) {
		UniqueIdentifier = uniqueIdentifier;
	}

	/**
	 * Getter. 
	 * @return XMLTag key format type of the object on the server.
	 */
	@XmlElement(name="KeyFormatType")
	public XMLTag getKeyFormatType() {
		return KeyFormatType;
	}

	/**
	 * Setter.
	 * @param keyFormatType key format type of the object on the server. For eg. "Raw".
	 */
	public void setKeyFormatType(XMLTag keyFormatType) {
		KeyFormatType = keyFormatType;
	}

	/**
	 * Parameterized constructor.
	 * @param uniqueIdentifier unique identifier of the object on the server.
	 * @param keyFormatType key format type of the object on the server.
	 */
	public RequestPayload(XMLTag uniqueIdentifier, XMLTag keyFormatType) {
		UniqueIdentifier = uniqueIdentifier;
		KeyFormatType = keyFormatType;
	}

	/**
	 * Parameterized constructor.
	 * @param uniqueIdentifier unique identifier of the object on the server.
	 */
	public RequestPayload(XMLTag uniqueIdentifier) {
		UniqueIdentifier = uniqueIdentifier;
	}

	/**
	 * Parameterized constructor.
	 * @param attributes information regarding the object, for eg. "VendorIdentificationNumber".
	 */
	public RequestPayload(List<JAXBElement<Object>> attributes) {
		this.attributes = attributes;
	}

	/**
	 * Parameterized constructor.
	 * @param commonAttributes attributes that are applicable to both the private as well as public key.
	 * @param privateKeyAttributes attributes only applicable to private key.
	 * @param publicKeyAttributes attributes only applicable to public key.
	 */
	public RequestPayload(CommonAttributes commonAttributes, PrivateKeyAttributes privateKeyAttributes,
			PublicKeyAttributes publicKeyAttributes) {
		this.commonAttributes = commonAttributes;
		this.privateKeyAttributes = privateKeyAttributes;
		this.publicKeyAttributes = publicKeyAttributes;
	}

	/**
	 * Getter. 
	 * @return CommonAttributes
	 */
	@XmlElement(name="CommonAttributes")
	public CommonAttributes getCommonAttributes() {
		return commonAttributes;
	}

	/**
	 * Setter.
	 * @param commonAttributes attributes applicable to private as well as public key.
	 */
	public void setCommonAttributes(CommonAttributes commonAttributes) {
		this.commonAttributes = commonAttributes;
	}

	/**
	 * Getter.
	 * @return PrivateKeyattributes
	 */
	@XmlElement(name="PrivateKeyAttributes")
	public PrivateKeyAttributes getPrivateKeyAttributes() {
		return privateKeyAttributes;
	}

	/**
	 * Setter.
	 * @param privateKeyAttributes attributes applicable to only private key.
	 */
	public void setPrivateKeyAttributes(PrivateKeyAttributes privateKeyAttributes) {
		this.privateKeyAttributes = privateKeyAttributes;
	}

	/**
	 * GEtter.
	 * @return PublicKeyAttributes
	 */
	@XmlElement(name="PublicKeyAttributes")
	public PublicKeyAttributes getPublicKeyAttributes() {
		return publicKeyAttributes;
	}

	/**
	 * Setter.
	 * @param publicKeyAttributes attributes applicable to only public key.
	 */
	public void setPublicKeyAttributes(PublicKeyAttributes publicKeyAttributes) {
		this.publicKeyAttributes = publicKeyAttributes;
	}

	

}
