package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Objects.ProtocolVersion;
import Objects.XMLTag;

/**
 * ResponseHeader POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see ProtocolVersion
 * @see XMLTag
 */ 
@XmlRootElement(name = "ResponseHeader")
@XmlType(propOrder = {"protocolVersion", "batchCount"})
public class ResponseHeader {
	
	ProtocolVersion protocolVersion;
	XMLTag BatchCount;

	/**
	 * Default constructor.
	 */
	public ResponseHeader(){
		
	}

	/**
	 * Parameterized constructor.
	 * @param protocolVersion the KMIP version you want to use. For eg. "2.0".
	 * @param batchCount the number of batch items, if there are more than one.
	 */
	public ResponseHeader(ProtocolVersion protocolVersion, XMLTag batchCount) {
		this.protocolVersion = protocolVersion;
		BatchCount = batchCount;
	}

	/**
	 * Getter.
	 * @return ProtocolVersion the KMIP version
	 */
	@XmlElement(name = "ProtocolVersion") //yes
	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	/**
	 * Setter.
	 * @param protocolVersion the KMIP version being used.
	 */
	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	
	/**
	 * Getter.
	 * @return XMLTag batch count (number of batch items. Usually used when there are more than one).
	 */
	@XmlElement(name = "BatchCount")
	public XMLTag getBatchCount() {
		return BatchCount;
	}

	/**
	 * Setter.
	 * @param batchCount the number of batch items, usually used if there are more than one.
	 */
	public void setBatchCount(XMLTag batchCount) {
		BatchCount = batchCount;
	}

    @Override
    public String toString() {
        return "ResponseHeader [BatchCount=" + BatchCount + ", protocolVersion=" + protocolVersion + "]";
    }

    
	

}
