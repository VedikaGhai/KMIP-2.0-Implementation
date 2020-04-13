package ClientInterfaces;

import java.security.Key;
import java.util.*;

public class KeyUniqueIDMap
{
    String uniqueIdentifier;
    String algorithm;
    int length;
    String value;
    String type;

    String privateKeyNameValue;
    String publicKeyNameValue;

    List<String> requiredValues;
    
    KeyUniqueIDMap(String algorithm, int length, String type)
    {
        this.algorithm=algorithm;
        this.length=length;
        this.type=type;
        requiredValues = new ArrayList<String>();
    }

    KeyUniqueIDMap(KeyUniqueIDMap k, List<String> requiredValues)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.type=k.type;
        this.requiredValues = requiredValues;
    }

    //Constructor for create operation
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier, String value)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.value=value;
        this.uniqueIdentifier=uniqueIdentifier;
        this.type=k.type;
        requiredValues = new ArrayList<String>();
    }

    //Constructor for get operation
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.type=k.type;
        //this.value=value;
        this.uniqueIdentifier=uniqueIdentifier;
        requiredValues = new ArrayList<String>();
    }

    public KeyUniqueIDMap(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        requiredValues = new ArrayList<String>();
    }

	public KeyUniqueIDMap() {
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public KeyUniqueIDMap(String algorithm, int length, String type, String privateKeyNameValue,
            String publicKeyNameValue) {
        this.algorithm = algorithm;
        this.length = length;
        this.type = type;
        this.privateKeyNameValue = privateKeyNameValue;
        this.publicKeyNameValue = publicKeyNameValue;
    }
    
}