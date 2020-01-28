package ClientInterfaces;

import java.io.*;
import java.security.Security;
import java.security.PrivilegedActionException;

import javax.net.ssl.*;
//import com.sun.net.ssl.internal.ssl.Provider;

public class Server {

    public static void main(String[] args) throws Exception {
        boolean debug = true;
        int intSSLport = 4000;

        {
            //Security.addProvider(new Provider());

            System.setProperty("javax.net.ssl.keyStore","/home/soha/keystore.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "password");
        }

        if(debug){
            System.setProperty("javax.net.debug", "all");
        }
        try {
            SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketfactory.createServerSocket(intSSLport);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            while (true) {
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                String inputLine=null;

                while ((inputLine = in.readLine()) != null) {
                    /*out.println(inputLine);
                    System.out.println(inputLine);*/
                    System.out.println("Hello");
                }

                File f= new File("/home/soha/Documents/Response2.xml");
                //byte[] requestMessageByteArray = new byte[(int)f.length()];
                DataInputStream bis= new DataInputStream(new FileInputStream(f));
                DataOutputStream bout= new DataOutputStream(sslSocket.getOutputStream());
                bout.writeUTF(bis.readUTF());

                Thread.sleep(1000);

                //out.close();
                //in.close();
                //bis.close();
                //sslSocket.close();
                //sslServerSocket.close();

            }
        }
        
        catch (Exception exp) {
            PrivilegedActionException priexp = new PrivilegedActionException(exp);
            System.out.println(" Priv exp --- " + priexp.getMessage());
            System.out.println(" Exception occurred .... " + exp);
            exp.printStackTrace();
        }

    }

}