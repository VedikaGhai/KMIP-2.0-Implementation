package Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlElements;

import Attributes.*;
import Enum.EnumTag;
import Objects.XMLTag;

@XmlRootElement(name = "RequestPayload")
@XmlSeeAlso({Attribute.class, XMLTag.class})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestPayload {
	
	XMLTag objectType;
	//Attribute[] attributes;

	//@XmlElementWrapper(name = "Attributes")
	//@XmlElement(name="Attribute")
	//@XmlElement(name = "Attributes")
	//@XmlElementRef
	List<Object> attributes;
	//List<XMLTag> attributes;

	public RequestPayload(){
		
	}

	public RequestPayload(XMLTag objectType, List<Object> attributes) {
		this.attributes =  new ArrayList<Object>();
		this.objectType = objectType;
		this.attributes = attributes;
	}

	@XmlElement(name = "ObjectType")
	public XMLTag getObjectType() {
		return objectType;
	}

	public void setObjectType(XMLTag objectType) {
		this.objectType = objectType;
	}
	
	/*
	@XmlElements({
		@XmlElement(type=Attribute.class)
		@XmlElement(type = XMLTag.class)
	})*/
	@XmlElementWrapper(name= "Attributes")
	//@XmlElementRef()
	//@XmlAnyElement(lax = true)
	//@XmlElement(name = "Attribute")
	@XmlElements({
		@XmlElement(name="Attribute", type=Attribute.class),
		@XmlElement(name="CryptographicAlgorithm", type=XMLTag.class),
		@XmlElement(name="CryptographicLength", type=XMLTag.class),
		@XmlElement(name="CryptographicUsageMask", type=XMLTag.class)
	})
	public List<Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "RequestPayload [attributes=" + attributes + ", objectType=" + objectType + "]";
	}

}
