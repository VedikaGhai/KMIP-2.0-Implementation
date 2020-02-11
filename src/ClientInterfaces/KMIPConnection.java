package ClientInterfaces;
import java.io.*;
import java.net.Socket;
import java.util.*;
import javax.net.ssl.*;


public class KMIPConnection
{

    Connection connect(String ip, int port)
    {
        try {
                   
            System.setProperty("javax.net.ssl.trustStore","/home/soha/keystore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");
    
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            try {
                Socket socket = sslSocketFactory.createSocket(ip, port);
                Connection connection= new Connection(socket, ip, port);
                return connection;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        finally{
            //
        }
        return null;

    }
}