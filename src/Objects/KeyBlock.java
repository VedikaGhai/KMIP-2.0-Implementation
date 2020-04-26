package Objects;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

/**
 * KeyBlock POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 * @see KeyValue
 */ 
public class KeyBlock
{
    
    XMLTag KeyFormatType;
    KeyValue keyValue;
    XMLTag cryptographicLength;
    XMLTag cryptographicAlgorithm;

    /**
     * Parameterized constructor.
     * @param keyFormatType 
     * @param keyValue value of the actual key/object.
     * @param cryptographicLength length of the key.
     * @param cryptographicAlgorithm cryptographic algorithm.
     */
    public KeyBlock(XMLTag keyFormatType, KeyValue keyValue, XMLTag cryptographicLength, XMLTag cryptographicAlgorithm) {
        KeyFormatType = keyFormatType;
        this.keyValue = keyValue;
        this.cryptographicLength = cryptographicLength;
        this.cryptographicAlgorithm = cryptographicAlgorithm;
    }

    /**
     * Getter.
     * @return XMLTag KeyFormatType
     */
    public XMLTag getKeyFormatType() {
        return KeyFormatType;
    }

    /**
     * Setter.
     * @param keyFormatType
     */
    public void setKeyFormatType(XMLTag keyFormatType) {
        KeyFormatType = keyFormatType;
    }

    /**
     * Getter.
     * @return KeyValue 
     */
    public KeyValue getKeyValue() {
        return keyValue;
    }

    /**
     * Setter.
     * @param keyValue actual value of the key
     */
    public void setKeyValue(KeyValue keyValue) {
        this.keyValue = keyValue;
    }

    /**
     * Getter.
     * @return XMLTag cryptographic length
     */
    public XMLTag getCryptographicLength() {
        return cryptographicLength;
    }

    /**
     * Setter.
     * @param cryptographicLength length of the key
     */
    public void setCryptographicLength(XMLTag cryptographicLength) {
        this.cryptographicLength = cryptographicLength;
    }

    /**
     * Getter.
     * @return XMLTag cryptographic algorithm
     */
    public XMLTag getCryptographicAlgorithm() {
        return cryptographicAlgorithm;
    }

    /**
     * Setter.
     * @param cryptographicAlgorithm
     */
    public void setCryptographicAlgorithm(XMLTag cryptographicAlgorithm) {
        this.cryptographicAlgorithm = cryptographicAlgorithm;
    }
   
}
