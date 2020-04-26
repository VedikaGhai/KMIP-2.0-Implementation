package ClientInterfaces;

/**
 * GetKey POJO class 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPOperations
 */
public class GetKey extends KMIPOperations
{
    String uniqueIdentifier;

    /**
     * Parameterized constructor
     * @param uniqueIdentifier unique identifier of an already existing key on the server
     */
    public GetKey(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * Default constructor
     */
    public GetKey() {
    }

    /**
     * Getter
     * @return String Unique Identifier of an already existing key on the server
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Setter
     * @param uniqueIdentifier Unique Identifier of an already existing key on the server
     */
    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
