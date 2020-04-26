package Attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import Objects.XMLTag;

/**
 * Attributes POJO Class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */
@XmlRootElement(name = "Attribute")
@XmlAccessorType(XmlAccessType.NONE)
public class Attribute 
{
	XMLTag VendorIdentification;
	XMLTag AttributeName;
	XMLTag AttributeValue;

	/**
	 * Getter
	 * @return XMLTag Vendor Identification
	 */
	@XmlElement(name = "VendorIdentification")
	public XMLTag getVendorIdentification() {
		return VendorIdentification;
	}

	/**
	 * Setter
	 * @param vendorIdentification Vendor Identification
	 */
	public void setVendorIdentification(XMLTag vendorIdentification) {
		VendorIdentification = vendorIdentification;
	}

	/**
	 * Getter
	 * @return XMLTag Attribute name
	 */
	@XmlElement(name = "AttributeName")
	public XMLTag getAttributeName() {
		return AttributeName;
	}

	/**
	 * Setter
	 * @param attributeName Attribute name
	 */
	public void setAttributeName(XMLTag attributeName) {
		AttributeName = attributeName;
	}

	/**
	 * Getter
	 * @return XMLTag Attribute Value
	 */
	@XmlElement(name = "AttributeValue")
	public XMLTag getAttributeValue() {
		return AttributeValue;
	}

	/**
	 * Setter
	 * @param attributeValue Attribute Value
 	 */
	public void setAttributeValue(XMLTag attributeValue) {
		AttributeValue = attributeValue;
	}

	/**
	 * Parameterized constructor
	 * @param vendorIdentification vendor identification
	 * @param attributeName attribute name
	 * @param attributeValue attribute value
	 */
	public Attribute(XMLTag vendorIdentification, XMLTag attributeName, XMLTag attributeValue) {
		VendorIdentification = vendorIdentification;
		AttributeName = attributeName;
		AttributeValue = attributeValue;
	}

	/**
	 * Parameterized constructor
	 * @param attributeName attribute name
	 * @param attributeValue attribute value
	 */
	public Attribute(XMLTag attributeName, XMLTag attributeValue) {
		AttributeName = attributeName;
		AttributeValue = attributeValue;
	}
	
	/**
	 * Default constructor
	 */
	public Attribute()
	{

	}
	
	
}
