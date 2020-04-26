package ClientInterfaces;

/**
 * DestroyKey POJO class 
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPOperations
 */
public class DestroyKey extends KMIPOperations
{
    String uniqueIdentifier;

    /**
     * Parameterized constructor
     * @param uniqueIdentifier Unique Identifier of the key to be destroyed
     */
    public DestroyKey(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * Default constructor
     */
    public DestroyKey() {
    }

    /**
     * Getter
     * @return String Unique Identifier of the key to be destroyed
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }
    
    /**
     * Setter 
     * @param uniqueIdentifier Unique identifier of the key to be destroyed
     */
    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
