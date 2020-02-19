package ClientInterfaces;



public class CreateKey extends KMIPOperations{
    //CreateKey specific methods
    String algorithm;
    String typeOfKey;
    int length;
    
    public CreateKey(String algorithm, String typeOfkey, int length)
    {
        this.algorithm=algorithm;
        this.typeOfKey=typeOfkey;
        this.length=length;
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
