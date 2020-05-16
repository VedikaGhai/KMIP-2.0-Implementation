package com.ibm.model;

public class KeyPair {

    private String TypeOfKey;
    private String Algorithm;
    private int KeySize;
    private String PrivateKeyUniqueIdentifier;
    private String PublicKeyUniqueIdentifier;
    private String PrivateKeyNameValue;
    private String PublicKeyNameValue;

    public KeyPair(){

    }

    public KeyPair(String typeOfKey, String algorithm, int keySize, String privateKeyUniqueIdentifier,
            String publicKeyUniqueIdentifier, String privateKeyNameValue, String publicKeyNameValue) {
        TypeOfKey = typeOfKey;
        Algorithm = algorithm;
        KeySize = keySize;
        PrivateKeyUniqueIdentifier = privateKeyUniqueIdentifier;
        PublicKeyUniqueIdentifier = publicKeyUniqueIdentifier;
        PrivateKeyNameValue = privateKeyNameValue;
        PublicKeyNameValue = publicKeyNameValue;
    }

    public String getTypeOfKey() {
        return TypeOfKey;
    }

    public void setTypeOfKey(String typeOfKey) {
        TypeOfKey = typeOfKey;
    }

    public String getAlgorithm() {
        return Algorithm;
    }

    public void setAlgorithm(String algorithm) {
        Algorithm = algorithm;
    }

    public int getKeySize() {
        return KeySize;
    }

    public void setKeySize(int keySize) {
        KeySize = keySize;
    }

    public String getPrivateKeyUniqueIdentifier() {
        return PrivateKeyUniqueIdentifier;
    }

    public void setPrivateKeyUniqueIdentifier(String privateKeyUniqueIdentifier) {
        PrivateKeyUniqueIdentifier = privateKeyUniqueIdentifier;
    }

    public String getPublicKeyUniqueIdentifier() {
        return PublicKeyUniqueIdentifier;
    }

    public void setPublicKeyUniqueIdentifier(String publicKeyUniqueIdentifier) {
        PublicKeyUniqueIdentifier = publicKeyUniqueIdentifier;
    }

    public String getPrivateKeyNameValue() {
        return PrivateKeyNameValue;
    }

    public void setPrivateKeyNameValue(String privateKeyNameValue) {
        PrivateKeyNameValue = privateKeyNameValue;
    }

    public String getPublicKeyNameValue() {
        return PublicKeyNameValue;
    }

    public void setPublicKeyNameValue(String publicKeyNameValue) {
        PublicKeyNameValue = publicKeyNameValue;
    }

    

    

}