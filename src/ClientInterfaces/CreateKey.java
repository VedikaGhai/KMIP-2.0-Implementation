package ClientInterfaces;

public class CreateKey extends KMIPOperations
{
    //CreateKey specific methods
    String algorithm;
    String typeOfKey;
    int length;
    
    
    public CreateKey(String algorithm, String typeOfkey, int length)
    {
        this.algorithm=algorithm;
        this.typeOfKey=typeOfKey;
        this.length=length;
    }
}
