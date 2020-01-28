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
        PrintWriter out;
        //DataInputStream din;
        InputStreamReader din;
        BufferedReader b1;

        //DataInputStream bis;
        InputStreamReader bis;
        BufferedReader b2;

        DataOutputStream bout;
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

            //while (true) {
                out = new PrintWriter(sslSocket.getOutputStream(),true);
                //BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                //din= new DataInputStream(sslSocket.getInputStream());
                din = new InputStreamReader(sslSocket.getInputStream());
                b1 = new BufferedReader(din);

                //String inputLine=null;

                /*while ((inputLine = in.readLine()) != null) {
                    /*out.println(inputLine);
                    System.out.println(inputLine);
                    System.out.println("Hello");
                }*/
                //Thread.sleep(10000);
                String str = "";

                while((str=b1.readLine())!=null)
                {
                    System.out.println(str);
                }
                //String str=b1.readLine();
                //System.out.println("Hello");
                File f= new File("/home/soha/Documents/Response2.xml");
                //byte[] requestMessageByteArray = new byte[(int)f.length()];
                bis= new InputStreamReader(new FileInputStream(f), "UTF-8");
                b2 = new BufferedReader(bis);
                
                bout= new DataOutputStream(sslSocket.getOutputStream());
                bout.writeUTF(b2.readLine());

                Thread.sleep(1000);

        

            //}
            //out.close();
                din.close();
                bis.close();
                sslSocket.close();
                sslServerSocket.close();
        }
        
        catch (Exception exp) {
            PrivilegedActionException priexp = new PrivilegedActionException(exp);
            System.out.println(" Priv exp --- " + priexp.getMessage());
            System.out.println(" Exception occurred .... " + exp);
            exp.printStackTrace();
        }

    }

}
