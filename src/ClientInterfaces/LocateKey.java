package ClientInterfaces;

/**
 * LocateKey POJO class 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPOperations
 */
public class LocateKey extends KMIPOperations
{
    String typeOfKey;

    /**
     * Default constructor
     */
    public LocateKey() {
    }

    /**
     * Parameterized constructor
     * @param typeOfKey type of key (for eg. "SymmetricKey, "PublicKey", "PrivateKey")
     */
    public LocateKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
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
     * @param typeOfKey type of key (for eg. "SymmetricKey, "PublicKey", "PrivateKey")
     */
    public void setTypeOfKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

}