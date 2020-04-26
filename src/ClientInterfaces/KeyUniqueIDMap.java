package ClientInterfaces;

import java.util.*;

/**
 * KeyUniqueIDMap POJO class for wrapping together a key's information (cryptographic algorithm,
 * key length, key type, etc) with the key's UniqueIdentifier.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 */
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
    
    /**
     * Parameterized constructor.
     * @param algorithm cryptographic algorithm
     * @param length length of the key in bits
     * @param type type of key
     */
    KeyUniqueIDMap(String algorithm, int length, String type)
    {
        this.algorithm=algorithm;
        this.length=length;
        this.type=type;
        requiredValues = new ArrayList<String>();
    }
    
    /**
     * Parameterized constructor.
     * @param k KeyUniqueIDMap object
     * @param requiredValues information extracted from server's response message, sent in the form of a List of strings
     */
    KeyUniqueIDMap(KeyUniqueIDMap k, List<String> requiredValues)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.type=k.type;
        this.requiredValues = requiredValues;
    }

    /**
     * Parameterized constructor.
     * @param k KeyUniqueIDMap object
     * @param uniqueIdentifier UniqueIdentifier of the key
     * @param value 
     */
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier, String value)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.value=value;
        this.uniqueIdentifier=uniqueIdentifier;
        this.type=k.type;
        requiredValues = new ArrayList<String>();
    }

    /**
     * Parameterized constructor.
     * @param k KeyUniqueIDMap object
     * @param uniqueIdentifier UniqueIdentifier of the key
     */
    KeyUniqueIDMap(KeyUniqueIDMap k, String uniqueIdentifier)
    {
        this.algorithm=k.algorithm;
        this.length=k.length;
        this.type=k.type;
        this.uniqueIdentifier=uniqueIdentifier;
        requiredValues = new ArrayList<String>();
    }

    /**
     * Parameterized constructor.
     * @param uniqueIdentifier UniqueIdentifier of the key.
     */
    public KeyUniqueIDMap(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        requiredValues = new ArrayList<String>();
    }

    /**
     * Default constructor
     */
	public KeyUniqueIDMap() {
	}

	/**
	 * Getter
	 * @return String type of key
	 */
    public String getType() {
        return type;
    }

    /**
     * Setter
     * @param type type of key
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Parameterized constructor.
     * @param algorithm cryptographic algorithm
     * @param length length of the key in bits
     * @param type type of the key
     * @param privateKeyNameValue a unique, meaningful private key name
     * @param publicKeyNameValue a unique, meaningful public key name
     */
    public KeyUniqueIDMap(String algorithm, int length, String type, String privateKeyNameValue,
            String publicKeyNameValue) {
        this.algorithm = algorithm;
        this.length = length;
        this.type = type;
        this.privateKeyNameValue = privateKeyNameValue;
        this.publicKeyNameValue = publicKeyNameValue;
    }
    
}