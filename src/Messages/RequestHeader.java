package Messages;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Objects.ProtocolVersion;
import Objects.XMLTag;

@XmlRootElement(name = "RequestHeader")
//@XmlType(propOrder = {"protocolVersion", "BatchCount", "BatchOrderOption", "ClientCorrelationValue"})
public class RequestHeader {
	
	ProtocolVersion protocolVersion;
	XMLTag ClientCorrelationValue;
	XMLTag BatchOrderOption;
	XMLTag BatchCount;

	public RequestHeader(){
		
	}

	public RequestHeader(ProtocolVersion protocolVersion, XMLTag clientCorrelationValue, XMLTag batchOrderOption,
			XMLTag batchCount) {
		this.protocolVersion = protocolVersion;
		ClientCorrelationValue = clientCorrelationValue;
		BatchOrderOption = batchOrderOption;
		BatchCount = batchCount;
	}

	public RequestHeader(ProtocolVersion protocolVersion, XMLTag clientCorrelationValue, XMLTag batchCount)
	{
		this.protocolVersion = protocolVersion;
		ClientCorrelationValue = clientCorrelationValue;
		BatchCount = batchCount;
	}

	@XmlElement(name = "ProtocolVersion") //yes
	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	
	@XmlElement(name = "ClientCorrelationValue") //yes
	public XMLTag getClientCorrelationValue() {
		return ClientCorrelationValue;
	}

	public void setClientCorrelationValue(XMLTag clientCorrelationValue) {
		ClientCorrelationValue = clientCorrelationValue;
	}

	//@XmlElement(name = )
	public XMLTag getBatchOrderOption() {
		return BatchOrderOption;
	}

	public void setBatchOrderOption(XMLTag batchOrderOption) {
		BatchOrderOption = batchOrderOption;
	}

	@XmlElement(name = "BatchCount")
	public XMLTag getBatchCount() {
		return BatchCount;
	}

	public void setBatchCount(XMLTag batchCount) {
		BatchCount = batchCount;
	}

	@Override
	public String toString() {
		return "RequestHeader [BatchCount=" + BatchCount + ", BatchOrderOption=" + BatchOrderOption
				+ ", ClientCorrelationValue=" + ClientCorrelationValue + ", protocolVersion=" + protocolVersion + "]";
	}

	

}
