package Messages;

import java.util.ArrayList;
import java.util.List;

import Attributes.Attribute;
import Objects.XMLTag;

public class RequestPayload {
	XMLTag objectType;
	//Attribute[] attributes;
	List<Attribute> attributes;

	public RequestPayload(XMLTag objectType, List<Attribute> attributes) {
		this.attributes =  new ArrayList<Attribute>();
		this.objectType = objectType;
		this.attributes = attributes;
	}

	public XMLTag getObjectType() {
		return objectType;
	}

	public void setObjectType(XMLTag objectType) {
		this.objectType = objectType;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "RequestPayload [attributes=" + attributes + ", objectType=" + objectType + "]";
	}

	
	

}
