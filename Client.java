import java.io.*;
import java.net.Socket;
import java.util.*;
import javax.net.ssl.*;
 
public class Client {
     
    static final int port = 3000;
 
    public static void main(String[] args) {
         
        try {
        // final char[] password = "password".toCharArray();
        // final KeyStore keyStore = KeyStore.getInstance(new File("D:/keystore.jks"), password);
        // final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // trustManagerFactory.init(keyStore);

        // final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("NewSunX509");
        // keyManagerFactory.init(keyStore, password);

        // final SSLContext context = SSLContext.getInstance("TLS");//"SSL" "TLS"
        // context.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        System.setProperty("javax.net.ssl.trustStore","D:/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        try {
            Socket socket = sslSocketFactory.createSocket("localhost", port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                Scanner scanner = new Scanner(System.in);
                while(true){
                    System.out.println("Enter something:");
                    String inputLine = scanner.nextLine();
                    if(inputLine.equals("Over")){
                        break;
                    }
                    out.println(inputLine);
                    System.out.println(bufferedReader.readLine());

                    String line = bufferedReader.readLine();
                    System.out.println(line);
                    out.println(line);
                }
                scanner.close();
            }
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        } 
    }
}
