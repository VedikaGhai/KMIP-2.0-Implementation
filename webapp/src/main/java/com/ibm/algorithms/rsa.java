package com.ibm.algorithms;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import javax.xml.bind.DatatypeConverter;


public class rsa {

    public String encrypt(String strToEncrypt, String KeyValue)
    {
        PublicKey publickey = null;
        byte[] keyByte = null;

        try
        {
            //PublicKey publickeyspec = Asymmetrickey.get_asymmetric_public_key(publickeyuuid);
            keyByte= DatatypeConverter.parseHexBinary(KeyValue);
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyByte);
            KeyFactory keyFact = KeyFactory.getInstance("RSA");
            publickey = keyFact.generatePublic(x509KeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.ENCRYPT_MODE,publickey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String KeyValue)
    {
        PrivateKey privatekey = null;
        byte[] keyByte = null;

        try
        {
            keyByte= DatatypeConverter.parseHexBinary(KeyValue);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyByte);
            KeyFactory keyFact = KeyFactory.getInstance("RSA");
            privatekey = keyFact.generatePrivate(keySpec);
            //PublicKey privatekeyspec = Asymmetrickey.get_asymmetric_private_key(privatekeyuuid);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.DECRYPT_MODE,privatekey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }    
    
}