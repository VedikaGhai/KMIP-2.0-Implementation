package ClientInterfaces;
import java.io.*;
import java.lang.*;

public class MainApplication
{
    public void mainCreate(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Algorithm :");
        String algorithm=buf.readLine();
        System.out.println("Type :");
        String type=buf.readLine();
        System.out.println("Key length :");
        int length= Integer.parseInt(buf.readLine());

        KeyUniqueIDMap k = new KeyUniqueIDMap(algorithm, length, type);
        //System.out.println(k.type);
        KeyUniqueIDMap kr = kops.create(k, connection);
        
        System.out.println(kr.uniqueIdentifier);
    }

    public void mainGet(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Unique Identifier :");
        String uniqueIdentifier = buf.readLine();
        
        KeyUniqueIDMap kg = new KeyUniqueIDMap(uniqueIdentifier);
        KeyUniqueIDMap kgresponse = kops.get(kg, connection);
        
        System.out.println(kgresponse.uniqueIdentifier);
        System.out.println(kgresponse.value);
    }

    public void mainDestroy(BufferedReader buf, Connection connection, KMIPOperations kops) throws Exception
    {
        System.out.println("Unique Identifier :");
        String uniqueIdentifier = buf.readLine();
        
        KeyUniqueIDMap kdestroy = new KeyUniqueIDMap(uniqueIdentifier);
        KeyUniqueIDMap kdestroyresponse = kops.destroy(kdestroy, connection);
        
        System.out.println(kdestroyresponse.uniqueIdentifier);
        System.out.println(kdestroyresponse.value);
    }

    public static void main(String args[]) throws Exception
    {
        MainApplication m = new MainApplication();
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        KMIPConnection kconn = new KMIPConnection();
        Connection connection = kconn.connect("localhost", 5000);
        //Connection connection = kconn.connect("169.38.124.246", 9443); //String IP Address, integer port number
        KMIPOperations kops = new KMIPOperations();
        
        m.mainCreate(buf,connection, kops);
        //m.mainGet(buf, connection, kops);
        //m.mainDestroy(buf, connection, kops);
    }
    
}
