package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Objects.ProtocolVersion;
import Objects.XMLTag;

/**
 * RequestHeader POJO class.
 * It also describes the order in which the request header should be formed.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 * @see ProtocolVersion
 */ 
@XmlRootElement(name = "RequestHeader")
@XmlType(propOrder = {"protocolVersion", "batchCount", "batchOrderOption", "clientCorrelationValue"})
public class RequestHeader {
	
	ProtocolVersion protocolVersion;
	XMLTag ClientCorrelationValue;
	XMLTag BatchOrderOption;
	XMLTag BatchCount;

	/**
	 * Default constructor.
	 */
	public RequestHeader(){
		
	}

	/**
	 * Parameterized constructor.
	 * @param protocolVersion the version of KMIP that you want to use. For eg. "2.0". 
	 * @param clientCorrelationValue 
	 * @param batchOrderOption
	 * @param batchCount if there are more than one batch items, this parameter is required.
	 */
	public RequestHeader(ProtocolVersion protocolVersion, XMLTag clientCorrelationValue, XMLTag batchOrderOption,
			XMLTag batchCount) {
		this.protocolVersion = protocolVersion;
		ClientCorrelationValue = clientCorrelationValue;
		BatchOrderOption = batchOrderOption;
		BatchCount = batchCount;
	}

	/**
	 * Parameterized constructor.
	 * @param protocolVersion the version of KMIP that you want to use. For eg. "2.0". 
	 * @param clientCorrelationValue
	 * @param batchCount if there are more than one batch items, this parameter is required.
	 */
	public RequestHeader(ProtocolVersion protocolVersion, XMLTag clientCorrelationValue, XMLTag batchCount)
	{
		this.protocolVersion = protocolVersion;
		ClientCorrelationValue = clientCorrelationValue;
		BatchCount = batchCount;
	}

	/**
	 * Parameterized constructor.
	 * @param protocolVersion the version of KMIP that you want to use. For eg. "2.0". 
	 * @param batchCount if there are more than one batch items, this parameter is required.
	 */
	public RequestHeader(ProtocolVersion protocolVersion, XMLTag batchCount) 
	{
		this.protocolVersion = protocolVersion;
		BatchCount = batchCount;
	}

	/**
	 * Getter.
	 * @return ProtocolVersion 
	 */
	@XmlElement(name = "ProtocolVersion") //yes
	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	/**
	 * Setter.
	 * @param protocolVersion
	 */
	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	
	/**
	 * Getter.
	 * @return XMLTag ClientCorrelationValue
	 */
	@XmlElement(name = "ClientCorrelationValue") //yes
	public XMLTag getClientCorrelationValue() {
		return ClientCorrelationValue;
	}

	/**
	 * Setter. 
	 * @param clientCorrelationValue
	 */
	public void setClientCorrelationValue(XMLTag clientCorrelationValue) {
		ClientCorrelationValue = clientCorrelationValue;
	}

	/**
	 * Getter.
	 * @return XMLTag BatchOrderOption
	 */
	public XMLTag getBatchOrderOption() {
		return BatchOrderOption;
	}

	/**
	 * Setter.
	 * @param batchOrderOption
	 */
	public void setBatchOrderOption(XMLTag batchOrderOption) {
		BatchOrderOption = batchOrderOption;
	}

	/**
	 * Getter.
	 * @return XMLTag batch count, if there are more than one batch items.
	 */
	@XmlElement(name = "BatchCount")
	public XMLTag getBatchCount() {
		return BatchCount;
	}

	/**
	 * Setter.
	 * @param batchCount usually only used if there are more than one batch items.
	 */
	public void setBatchCount(XMLTag batchCount) {
		BatchCount = batchCount;
	}

	@Override
	public String toString() {
		return "RequestHeader [BatchCount=" + BatchCount + ", BatchOrderOption=" + BatchOrderOption
				+ ", ClientCorrelationValue=" + ClientCorrelationValue + ", protocolVersion=" + protocolVersion + "]";
	}

	

}
