package ClientInterfaces;

import java.io.*;
import java.lang.*;
import java.util.*;

public class MainApplication
{
    public void mainCreate(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Algorithm :");
        String algorithm=buf.readLine();
        System.out.println("Object Type :");
        String type=buf.readLine();
        System.out.println("Key length :");
        int length= Integer.parseInt(buf.readLine());

        //System.out.println(k.type);
        //KeyUniqueIDMap kr = kops.create(k, connection);
        

        if(type.equalsIgnoreCase("SymmetricKey"))
        {
            KeyUniqueIDMap k = new KeyUniqueIDMap(algorithm, length, type);
            KeyUniqueIDMap kr = kops.create(k,connection);
            //System.out.println(kr.requiredValues);
        }
        else if(type.equalsIgnoreCase("AsymmetricKey"))
        {
            System.out.println("Private Key Name Value :");
            String privateKeyNameValue = buf.readLine();
            System.out.println("Public Key Name Value : ");
            String publicKeyNameValue = buf.readLine();

            KeyUniqueIDMap k = new KeyUniqueIDMap(algorithm, length, type, privateKeyNameValue, publicKeyNameValue);
            KeyUniqueIDMap kr = kops.createKeyPair(k,connection);
            //System.out.println(kr.requiredValues);
        }

        
    }

    public void mainGet(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Unique Identifier :");
        String uniqueIdentifier = buf.readLine();

        KeyUniqueIDMap kg = new KeyUniqueIDMap(uniqueIdentifier);
        KeyUniqueIDMap kgresponse = kops.get(kg, connection);
        
        //System.out.println(kgresponse.uniqueIdentifier);
        //System.out.println(kgresponse.value);
        //System.out.println(kgresponse.requiredValues);
    }

    public void mainDestroy(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Unique Identifier :");
        String uniqueIdentifier = buf.readLine();
        
        KeyUniqueIDMap kdestroy = new KeyUniqueIDMap(uniqueIdentifier);
        KeyUniqueIDMap kdestroyresponse = kops.destroy(kdestroy, connection);
        
        //System.out.println(kdestroyresponse.requiredValues);
    }

    public void mainLocate(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Object Type :");
        String objectType = buf.readLine();

        KeyUniqueIDMap klocate = new KeyUniqueIDMap();
        klocate.setType(objectType);
        KeyUniqueIDMap klocateresponse = kops.locate(klocate, connection);
        
        //System.out.println(klocateresponse.requiredValues);
    }

    public static void main(String args[]) throws Exception
    {
        MainApplication m = new MainApplication();
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        KMIPConnection kconn = new KMIPConnection();
        //Connection connection = kconn.connect("localhost", 5000);
        Connection connection = kconn.connect("hostname", portno); //instead of localhost, put IBM SKLM IP address, and instead of "portno", put KMIP port no.
        KMIPOperations kops = new KMIPOperations();
    
        //m.mainCreate(buf,connection, kops); //Create Key (Symmetric) and Create Key Pair (Asymmetric)
        //m.mainGet(buf, connection, kops); //Get Key
        //m.mainDestroy(buf, connection, kops); //Destroy Key
        m.mainLocate(buf, connection, kops); //Locate Key
    }
    
}