package ClientInterfaces;
import java.net.Socket;
import javax.net.ssl.*;


public class KMIPConnection
{

    Connection connect(String ip, int port)
    {
        try {
             
            /* KEYTOOL COMMAND for Mock Server :
            soha@soha-Inspiron-5559:~$ keytool -genkey -keyalg RSA -keystore keystore.jks -validity 300 -keysize 2048
            Enter keystore password:  
            Re-enter new password: 
            What is your first and last name?
            [Unknown]:  Soha
            What is the name of your organizational unit?
            [Unknown]:  Cummins
            What is the name of your organization?
            [Unknown]:  Cummins
            What is the name of your City or Locality?
            [Unknown]:  Pune   
            What is the name of your State or Province?
            [Unknown]:  maharashtra    
            What is the two-letter country code for this unit?
            [Unknown]:  IN
            Is CN=Soha, OU=Cummins, O=Cummins, L=Pune, ST=maharashtra, C=IN correct?
            [no]:  yes

            Enter key password for <mykey>
                (RETURN if same as keystore password):  
            */

            /*
            //Mock Server keystore
            System.setProperty("javax.net.ssl.trustStore","/home/soha/keystore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");
            */

            
            //IBM SKLM keystore
            System.setProperty("javax.net.ssl.trustStore","/home/soha/defaultKeyStore");
            System.setProperty("javax.net.ssl.trustStoreType", "JCEKS");
            System.setProperty("javax.net.ssl.trustStorePassword", "passw0rd");
            

            
            System.setProperty("javax.net.ssl.keyStore","/home/soha/defaultKeyStore");
            System.setProperty("javax.net.ssl.keyStoreType", "JCEKS");
            System.setProperty("javax.net.ssl.keyStorePassword", "passw0rd");
            

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
        finally {
            //
        }
        return null;

    }
}