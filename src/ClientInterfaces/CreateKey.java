package ClientInterfaces;

/**
 * CreateKey POJO class 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPOperations
 */
public class CreateKey extends KMIPOperations{
    
    String algorithm;
    String typeOfKey;
    int length;
    
    /**
     * Parameterized constructor
     * @param algorithm cryptographic algorithm (for eg. AES)
     * @param typeOfkey for eg. SymmetricKey
     * @param length length of the key in bits (for eg. 128)
     */
    public CreateKey(String algorithm, String typeOfkey, int length)
    {
        this.algorithm=algorithm;
        this.typeOfKey=typeOfkey;
        this.length=length;
    }

    /**
     * Getter 
     * @return String Cryptographic algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Setter
     * @param algorithm Cryptographic Algorithm
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Getter
     * @return String Type of key
     */
    public String getTypeOfKey() {
        return typeOfKey;
    }

    /**
     * Setter
     * @param typeOfKey Type of key
     */
    public void setTypeOfKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

    /**
     * Getter
     * @return int length of key in bits
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter
     * @param length length of key in bits
     */
    public void setLength(int length) {
        this.length = length;
    }
}
