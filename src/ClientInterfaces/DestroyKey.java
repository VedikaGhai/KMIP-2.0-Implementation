package ClientInterfaces;

public class DestroyKey extends KMIPOperations
{
    String uniqueIdentifier;
    //

    public DestroyKey(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public DestroyKey() {
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
