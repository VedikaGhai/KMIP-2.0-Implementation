package ClientInterfaces;

public class KeyUniqueIDMap
{
    String uniqueIdentifier;
    String algorithm;
    int length;
    String value;
    String type;
    
    KeyUniqueIDMap(String algorithm, int length, String type)
    {
        this.algorithm=algorithm;
        this.length=length;
        this.type=type;
    }

    //Constructor for create operation
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier, String value)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.value=value;
        this.uniqueIdentifier=uniqueIdentifier;
        this.type=k.type;
    }

    //Constructor for get operation
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.type=k.type;
        //this.value=value;
        this.uniqueIdentifier=uniqueIdentifier;
    }
    
}