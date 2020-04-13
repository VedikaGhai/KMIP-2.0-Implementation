package Messages;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Objects.ProtocolVersion;
import Objects.XMLTag;

@XmlRootElement(name = "ResponseHeader")
@XmlType(propOrder = {"protocolVersion", "batchCount"})
public class ResponseHeader {
	
	ProtocolVersion protocolVersion;
	XMLTag BatchCount;

	public ResponseHeader(){
		
	}

	public ResponseHeader(ProtocolVersion protocolVersion, XMLTag batchCount) {
		this.protocolVersion = protocolVersion;
		BatchCount = batchCount;
	}

	@XmlElement(name = "ProtocolVersion") //yes
	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
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
        return "ResponseHeader [BatchCount=" + BatchCount + ", protocolVersion=" + protocolVersion + "]";
    }

    
	

}
