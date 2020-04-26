package ClientInterfaces;

/**
 * CreateKeyPair POJO class 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPOperations
 */
public class CreateKeyPair extends KMIPOperations{
    //CreateKey specific methods
    String algorithm;
    String typeOfKey;
    int length;
    String privateKeyNameValue;
    String publicKeyNameValue;
    
    /**
     * Parameterized constructor
     * @param algorithm cryptographic algorithm (for eg. RSA)
     * @param typeOfkey for eg. AsymmetricKey
     * @param length length of the key in bits (for eg. 1024)
     */
    public CreateKeyPair(String algorithm, String typeOfkey, int length)
    {
        this.algorithm=algorithm;
        this.typeOfKey=typeOfkey;
        this.length=length;
    }

    /**
     * Getter
     * @return String cryptographic algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Setter
     * @param algorithm cryptographic algorithm
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Getter 
     * @return String type of key
     */
    public String getTypeOfKey() {
        return typeOfKey;
    }

    /**
     * Setter
     * @param typeOfKey type of key
     */
    public void setTypeOfKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

    /**
     * Getter
     * @return int length of the key in bits
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter
     * @param length length of the key in bits
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Parameterized constructor
     * @param algorithm cryptographic algorithm (for eg. RSA)
     * @param typeOfkey for eg. AsymmetricKey
     * @param length length of the key in bits (for eg. 1024)
     * @param publicKeyNameValue a unique meaningful public key name
     * @param privateKeyNameValue a unique meaningful private key name
     */
    public CreateKeyPair(String algorithm, String typeOfKey, int length, String privateKeyNameValue,
            String publicKeyNameValue) {
        this.algorithm = algorithm;
        this.typeOfKey = typeOfKey;
        this.length = length;
        this.privateKeyNameValue = privateKeyNameValue;
        this.publicKeyNameValue = publicKeyNameValue;
    }

    /**
     * Getter
     * @return String Private key name
     */
    public String getPrivateKeyNameValue() {
        return privateKeyNameValue;
    }

    /**
     * Setter
     * @param privateKeyNameValue a unique, meaningful private key name
     */
    public void setPrivateKeyNameValue(String privateKeyNameValue) {
        this.privateKeyNameValue = privateKeyNameValue;
    }

    /**
     * Getter
     * @return String Public key name 
     */
    public String getPublicKeyNameValue() {
        return publicKeyNameValue;
    }

    /**
     * Setter 
     * @param publicKeyNameValue a unique, meaningful public key name
     */
    public void setPublicKeyNameValue(String publicKeyNameValue) {
        this.publicKeyNameValue = publicKeyNameValue;
    }
}
