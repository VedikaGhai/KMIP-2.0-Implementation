package ClientInterfaces;

import java.io.*;
import java.security.Security;
import java.util.Scanner;
import java.util.*;
import java.net.*;
import java.security.PrivilegedActionException;

import javax.net.ssl.*;

public class Server {
    
    public static void main(String[] args) throws Exception {
       
        Scanner scanner = new Scanner(System.in);

        FileReader fr;
        BufferedReader br;

        int port = 5000;
        System.setProperty("javax.net.ssl.keyStore","/home/soha/keystore.jks");
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
                    System.out.println("********************REQUEST RECEIVED FROM CLIENT********************");
                    System.out.println(line);
                    //out.println(line);
                    Thread.sleep(2000);

                    fr = new FileReader("/home/soha/Documents/Response1.xml");
                    br = new BufferedReader(fr);    
                    String i;
                    String request = "";    
                    while((i=br.readLine())!=null)    
                        //System.out.print((char)i);    
                        request+= i;
                    System.out.println("********************RESPONSE SENT TO CLIENT********************");
                    out.println(request);
                    //out.println(fr);
                    /*System.out.println("Enter something:");
                    String inputLine = scanner.nextLine();
                    if(inputLine.equals("Over")){
                        break;
                    }
                    out.println(inputLine);*/
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
