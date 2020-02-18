package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;
import Objects.XMLTag;

@XmlRootElement(name = "Attribute")
@XmlAccessorType(XmlAccessType.NONE)
public class Attribute 
{
	/*
	//@XmlAttribute(name = "name")
	String name;
	
	//@XmlAttribute(name = "value")
	KMIPType value;

	//@XmlAttribute(name = "type")
	EnumType type;

	//@XmlAttribute(name = "tag")
	EnumTag tag;

	int length;
	
	public Attribute(){
		//default constructor
	}
	//POJO
	public Attribute(String name, KMIPType value, EnumType type, EnumTag tag) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
		this.tag = tag;
		this.length=value.getDefaultLength();
	}
	
	//@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//@XmlElement
	public KMIPType getValue() {
		return value;
	}
	public void setValue(KMIPType value) {
		this.value = value;
	}
	//@XmlElement
	public EnumType getType() {
		return type;
	}
	public void setType(EnumType type) {
		this.type = type;
	}
	//@XmlElement
	public EnumTag getTag() {
		return tag;
	}
	public void setTag(EnumTag tag) {
		this.tag = tag;
	}
	//@XmlElement
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Attribute [length=" + length + ", name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value
				+ "]";
	}
	*/
	XMLTag VendorIdentification;
	XMLTag AttributeName;
	XMLTag AttributeValue;

	@XmlElement(name = "VendorIdentification")
	public XMLTag getVendorIdentification() {
		return VendorIdentification;
	}

	public void setVendorIdentification(XMLTag vendorIdentification) {
		VendorIdentification = vendorIdentification;
	}

	@XmlElement(name = "AttributeName")
	public XMLTag getAttributeName() {
		return AttributeName;
	}

	public void setAttributeName(XMLTag attributeName) {
		AttributeName = attributeName;
	}

	@XmlElement(name = "AttributeValue")
	public XMLTag getAttributeValue() {
		return AttributeValue;
	}

	public void setAttributeValue(XMLTag attributeValue) {
		AttributeValue = attributeValue;
	}

	public Attribute(XMLTag vendorIdentification, XMLTag attributeName, XMLTag attributeValue) {
		VendorIdentification = vendorIdentification;
		AttributeName = attributeName;
		AttributeValue = attributeValue;
	}

	public Attribute(XMLTag attributeName, XMLTag attributeValue) {
		AttributeName = attributeName;
		AttributeValue = attributeValue;
	}
	
	public Attribute()
	{

	}
	
	
}
