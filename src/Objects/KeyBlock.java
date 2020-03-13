package Objects;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class KeyBlock
{
    
    XMLTag KeyFormatType;
    KeyValue keyValue;
    XMLTag cryptographicLength;
    XMLTag cryptographicAlgorithm;

    public KeyBlock(XMLTag keyFormatType, KeyValue keyValue, XMLTag cryptographicLength, XMLTag cryptographicAlgorithm) {
        KeyFormatType = keyFormatType;
        this.keyValue = keyValue;
        this.cryptographicLength = cryptographicLength;
        this.cryptographicAlgorithm = cryptographicAlgorithm;
    }

    public XMLTag getKeyFormatType() {
        return KeyFormatType;
    }

    public void setKeyFormatType(XMLTag keyFormatType) {
        KeyFormatType = keyFormatType;
    }

    public KeyValue getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(KeyValue keyValue) {
        this.keyValue = keyValue;
    }

    public XMLTag getCryptographicLength() {
        return cryptographicLength;
    }

    public void setCryptographicLength(XMLTag cryptographicLength) {
        this.cryptographicLength = cryptographicLength;
    }

    public XMLTag getCryptographicAlgorithm() {
        return cryptographicAlgorithm;
    }

    public void setCryptographicAlgorithm(XMLTag cryptographicAlgorithm) {
        this.cryptographicAlgorithm = cryptographicAlgorithm;
    }
   
}
