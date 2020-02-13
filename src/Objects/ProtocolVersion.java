package Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.*;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRegistry
@XmlRootElement(name = "ProtocolVersion")
public class ProtocolVersion
{
    XMLTag ProtocolVersionMajor;
    XMLTag ProtocolVersionMinor;

    public ProtocolVersion(){
        
    }

    //constructor
    public ProtocolVersion(XMLTag protocolVersionMajor, XMLTag protocolVersionMinor) {
        ProtocolVersionMajor = protocolVersionMajor;
        ProtocolVersionMinor = protocolVersionMinor;
    }

    @XmlElement(name = "ProtocolVersionMajor")
    //@XmlElementDecl(scope = XMLTag.class, name = "ProtocolVersionMajor")
    public XMLTag getProtocolVersionMajor() {
        return ProtocolVersionMajor;
    }

    public void setProtocolVersionMajor(XMLTag protocolVersionMajor) {
        ProtocolVersionMajor = protocolVersionMajor;
    }
    
    @XmlElement(name = "ProtocolVersionMinor")
    public XMLTag getProtocolVersionMinor() {
        return ProtocolVersionMinor;
    }

    public void setProtocolVersionMinor(XMLTag protocolVersionMinor) {
        ProtocolVersionMinor = protocolVersionMinor;
    }

    @Override
    public String toString() {
        return "ProtocolVersion [ProtocolVersionMajor=" + ProtocolVersionMajor + ", ProtocolVersionMinor="
                + ProtocolVersionMinor + "]";
    }

    
}