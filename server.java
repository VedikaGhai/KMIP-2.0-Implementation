  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.net.ssl.SSLServerSocketFactory;
 
public class server
{
    static final int port = 3000;
    
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.setProperty("javax.net.ssl.keyStore","D:/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
     
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
         
        try {
            ServerSocket sslServerSocket = sslServerSocketFactory.createServerSocket(port);
            System.out.println("SSL ServerSocket started");
            System.out.println(sslServerSocket.toString());
             
            Socket socket = sslServerSocket.accept();
            System.out.println("ServerSocket accepted");
            Thread.sleep(1000); 
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                    out.println(line);

                    System.out.println("Enter something:");
                    String inputLine = scanner.nextLine();
                    if(inputLine.equals("Over")){
                        break;
                    }
                    out.println(inputLine);
                    //System.out.println(bufferedReader.readLine());
                }
            }
            System.out.println("Closed");
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       scanner.close();
    }
}