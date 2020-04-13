package ClientInterfaces;

public class GetKey extends KMIPOperations
{
    String uniqueIdentifier;

    public GetKey(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public GetKey() {
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
