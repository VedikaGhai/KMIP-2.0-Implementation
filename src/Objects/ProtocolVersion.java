package Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.bind.annotation.*;

/**
 * ProtocolVersion POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */ 
@XmlRegistry
@XmlRootElement(name = "ProtocolVersion")
public class ProtocolVersion
{
    XMLTag ProtocolVersionMajor;
    XMLTag ProtocolVersionMinor;

    /**
     * Default constructor.
     */
    public ProtocolVersion(){
        
    }

    /**
     * Parameterized constructor.
     * @param protocolVersionMajor the digit before the decimal point. For KMIP v 2.0, this will be "2".
     * @param protocolVersionMinor the digit after the decimal point. For KMIP v 2.0, this will be "0".
     */
    public ProtocolVersion(XMLTag protocolVersionMajor, XMLTag protocolVersionMinor) {
        ProtocolVersionMajor = protocolVersionMajor;
        ProtocolVersionMinor = protocolVersionMinor;
    }

    /**
     * Getter.
     * @return XMLTag PrtocolVersionMajor
     */
    @XmlElement(name = "ProtocolVersionMajor")
    public XMLTag getProtocolVersionMajor() {
        return ProtocolVersionMajor;
    }

    /**
     * Setter.
     * @param protocolVersionMajor
     */
    public void setProtocolVersionMajor(XMLTag protocolVersionMajor) {
        ProtocolVersionMajor = protocolVersionMajor;
    }
    
    /**
     * Getter.
     * @return XMLTag ProtocolVersionMinor
     */
    @XmlElement(name = "ProtocolVersionMinor")
    public XMLTag getProtocolVersionMinor() {
        return ProtocolVersionMinor;
    }

    /**
     * Setter.
     * @param protocolVersionMinor
     */
    public void setProtocolVersionMinor(XMLTag protocolVersionMinor) {
        ProtocolVersionMinor = protocolVersionMinor;
    }

    @Override
    public String toString() {
        return "ProtocolVersion [ProtocolVersionMajor=" + ProtocolVersionMajor + ", ProtocolVersionMinor="
                + ProtocolVersionMinor + "]";
    }

    
}