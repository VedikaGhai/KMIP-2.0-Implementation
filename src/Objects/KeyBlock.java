package Objects;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import Attributes.CryptographicAlgorithm;
import Attributes.CryptographicLength;

public class KeyBlock
{
    XMLTag KeyFormatType;
    KeyValue keyValue;
    CryptographicLength cryptographicLength;
    CryptographicAlgorithm cryptographicAlgorithm;

    public KeyBlock(XMLTag keyFormatType, KeyValue keyValue, CryptographicLength cryptographicLength, CryptographicAlgorithm cryptographicAlgorithm) {
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

    public CryptographicLength getCryptographicLength() {
        return cryptographicLength;
    }

    public void setCryptographicLength(CryptographicLength cryptographicLength) {
        this.cryptographicLength = cryptographicLength;
    }

    public CryptographicAlgorithm getCryptographicAlgorithm() {
        return cryptographicAlgorithm;
    }

    public void setCryptographicAlgorithm(CryptographicAlgorithm cryptographicAlgorithm) {
        this.cryptographicAlgorithm = cryptographicAlgorithm;
    }
   
}