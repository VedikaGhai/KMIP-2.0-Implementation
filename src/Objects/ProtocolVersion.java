package Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement
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

    @XmlElement
    public XMLTag getProtocolVersionMajor() {
        return ProtocolVersionMajor;
    }

    public void setProtocolVersionMajor(XMLTag protocolVersionMajor) {
        ProtocolVersionMajor = protocolVersionMajor;
    }
    
    @XmlElement
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