package ClientInterfaces;

public class CreateKeyPair extends KMIPOperations{
    //CreateKey specific methods
    String algorithm;
    String typeOfKey;
    int length;
    String privateKeyNameValue;
    String publicKeyNameValue;
    
    public CreateKeyPair(String algorithm, String typeOfkey, int length)
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

    public CreateKeyPair(String algorithm, String typeOfKey, int length, String privateKeyNameValue,
            String publicKeyNameValue) {
        this.algorithm = algorithm;
        this.typeOfKey = typeOfKey;
        this.length = length;
        this.privateKeyNameValue = privateKeyNameValue;
        this.publicKeyNameValue = publicKeyNameValue;
    }

    public String getPrivateKeyNameValue() {
        return privateKeyNameValue;
    }

    public void setPrivateKeyNameValue(String privateKeyNameValue) {
        this.privateKeyNameValue = privateKeyNameValue;
    }

    public String getPublicKeyNameValue() {
        return publicKeyNameValue;
    }

    public void setPublicKeyNameValue(String publicKeyNameValue) {
        this.publicKeyNameValue = publicKeyNameValue;
    }
}
