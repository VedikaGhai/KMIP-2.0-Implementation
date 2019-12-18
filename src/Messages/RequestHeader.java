package Messages;

import Objects.ProtocolVersion;
import Objects.XMLTag;

public class RequestHeader {
	ProtocolVersion protocolVersion;
	XMLTag ClientCorrelationValue;
	XMLTag BatchOrderOption;
	XMLTag BatchCount;

	public RequestHeader(ProtocolVersion protocolVersion, XMLTag clientCorrelationValue, XMLTag batchOrderOption,
			XMLTag batchCount) {
		this.protocolVersion = protocolVersion;
		ClientCorrelationValue = clientCorrelationValue;
		BatchOrderOption = batchOrderOption;
		BatchCount = batchCount;
	}

	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public XMLTag getClientCorrelationValue() {
		return ClientCorrelationValue;
	}

	public void setClientCorrelationValue(XMLTag clientCorrelationValue) {
		ClientCorrelationValue = clientCorrelationValue;
	}

	public XMLTag getBatchOrderOption() {
		return BatchOrderOption;
	}

	public void setBatchOrderOption(XMLTag batchOrderOption) {
		BatchOrderOption = batchOrderOption;
	}

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
