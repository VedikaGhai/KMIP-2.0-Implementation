package ClientInterfaces;
import java.io.*;

public class MainApplication
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        KMIPConnection kconn = new KMIPConnection();
        Connection connection = kconn.connect(" ", 0); //String IP Address, integer port number
        KMIPOperations kops = new KMIPOperations();
        System.out.println("Algorithm :");
        String algorithm=buf.readLine();
        System.out.println("Type :");
        String type=buf.readLine();
        System.out.println("Key length :");
        int length= Integer.parseInt(buf.readLine());
        KeyUniqueIDMap k= new KeyUniqueIDMap(algorithm, length, type);
        KeyUniqueIDMap kr=kops.create(k, connection);
        System.out.println(kr.uniqueIdentifier);

    }
}