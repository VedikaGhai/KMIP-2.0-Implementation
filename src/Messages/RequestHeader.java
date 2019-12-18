package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.ProtocolVersion;
import Objects.XMLTag;

@XmlRootElement
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

	@XmlElement
	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	@XmlElement
	public XMLTag getClientCorrelationValue() {
		return ClientCorrelationValue;
	}

	public void setClientCorrelationValue(XMLTag clientCorrelationValue) {
		ClientCorrelationValue = clientCorrelationValue;
	}
	@XmlElement
	public XMLTag getBatchOrderOption() {
		return BatchOrderOption;
	}

	public void setBatchOrderOption(XMLTag batchOrderOption) {
		BatchOrderOption = batchOrderOption;
	}
	@XmlElement
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
