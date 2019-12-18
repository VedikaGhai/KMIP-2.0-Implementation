package Objects;

public class ProtocolVersion{

    XMLTag ProtocolVersionMajor;
    XMLTag ProtocolVersionMinor;

    //constructor
    public ProtocolVersion(XMLTag protocolVersionMajor, XMLTag protocolVersionMinor) {
        ProtocolVersionMajor = protocolVersionMajor;
        ProtocolVersionMinor = protocolVersionMinor;
    }

    public XMLTag getProtocolVersionMajor() {
        return ProtocolVersionMajor;
    }

    public void setProtocolVersionMajor(XMLTag protocolVersionMajor) {
        ProtocolVersionMajor = protocolVersionMajor;
    }

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