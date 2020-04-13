package ClientInterfaces;

public class LocateKey extends KMIPOperations
{
    String typeOfKey;

    public LocateKey() {
    }

    public LocateKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

    public String getTypeOfKey() {
        return typeOfKey;
    }

    public void setTypeOfKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

}