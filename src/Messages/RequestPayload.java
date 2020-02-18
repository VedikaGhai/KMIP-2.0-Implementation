package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import Attributes.Attribute;
import Objects.XMLTag;

@XmlRootElement(name = "RequestPayload")
@XmlAccessorType(XmlAccessType.NONE)
public class RequestPayload {
	
	XMLTag objectType;
	//Attribute[] attributes;

	//@XmlElementWrapper(name = "Attributes")
	//@XmlElement(name="Attribute")
	//@XmlElement(name = "Attributes")
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
