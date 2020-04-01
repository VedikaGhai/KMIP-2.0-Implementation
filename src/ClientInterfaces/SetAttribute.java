package ClientInterfaces;

public class SetAttribute extends KMIPOperations
{
    String algorithm;
    String typeOfKey;
    int length;

    public SetAttribute(String algorithm, String typeOfKey, int length) {
        this.algorithm = algorithm;
        this.typeOfKey = typeOfKey;
        this.length = length;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getTypeOfKey() {
        return typeOfKey;
    }

    public void setTypeOfKey(String typeOfKey) {
        this.typeOfKey = typeOfKey;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}