package ClientInterfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.nio.file.*;

import Messages.CreateRequestMessage;
import Operations.DecodeResponseMessage;

public class KMIPOperations
{
    //call the desired operation class and its methods
    int port = 5000;
    FileReader fr;
    BufferedReader br;
    File f2;
    FileWriter fw;
    String line="";

    public KMIPOperations() 
    {
        
    }

    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.type, k.length);
        File f= createRequestMessage.createKeyRequestMessage(createKey);
        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        
        try 
        {
            PrintWriter out = new PrintWriter(connection.socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.socket.getInputStream())))
             {
                Scanner scanner = new Scanner(System.in);
                //while(true)
                //{
                    fr = new FileReader(f);
                    br = new BufferedReader(fr);    
                    String i;
                    String request="";    
                    while((i=br.readLine())!=null)    
                        //System.out.print((char)i);    
                        request+= i;

                    /*System.out.println("Enter something:");
                    String inputLine = scanner.nextLine();
                    if(inputLine.equals("Over"))
                    {
                        break;
                    }
                    out.println(inputLine);*/
                    System.out.println("******************REQUEST SENT TO SERVER***************");
                    out.println(request);
                    //System.out.println(bufferedReader.readLine());
                    Thread.sleep(2000);
                    line = bufferedReader.readLine();
                    //f2=new File("/home/soha/Documents/Response4.xml");
                    //fw= new FileWriter(f2);
                    //fw.write(line);
                    System.out.println("*****************RESPONSE RECEIVED FROM SERVER****************");
                    System.out.println(line);
                    //NOT WORKING! -> stringToDom(line);
                    //out.println(line);
                //}
                //scanner.close();
                //fr.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        } 

        //faaltu experiment
        Path pathXMLFile=Paths.get("/home/soha/Documents/Response5.xml");
        Files.write(pathXMLFile,line.getBytes(),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //NOT WORKING FROM HERE ONWARDS
        File response =new File("/home/soha/Documents/Response5.xml");
        /*DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(line);*/
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();
        String uniqueIdentifier = decodeResponseMessage.DOMParser(response);
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uniqueIdentifier);
        
        return responseUID;
    }

    /*public static void stringToDom(String xmlSource) throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException
    {
        // Parse the given input
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

        // Write the parsed document to an xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result =  new StreamResult(new File("/home/soha/ResponseMessage.xml"));
        transformer.transform(source, result);
    }*/

}
