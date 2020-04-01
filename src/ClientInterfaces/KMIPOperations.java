package ClientInterfaces;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.nio.file.*;

import Messages.CreateRequestMessage;
import Operations.DecodeResponseMessage;

public class KMIPOperations
{
    //call the desired operation class and its methods
    //int port = 5000;
    FileReader fr;
    BufferedReader br;
    File f2;
    FileWriter fw;
    String line="";
    
    OutputStream outputStream;
    DataOutputStream outTRIAL;

    InputStream inputStream;
    DataInputStream dataInputStream;
    ByteArrayInputStream byteArrayInputStream;

    public KMIPOperations() 
    {
        
    }

    private static String separator = System.getProperty("line.separator");

    public static byte[] getXMLOutMessage(byte[] dataOut)
    {
        byte[] httpHeader = null;
        byte[] httpOut = null;
        if(dataOut!=null)
        {
            httpHeader = createXMLHeader(dataOut.length).getBytes();
            httpOut = new byte[httpHeader.length + dataOut.length];

            for(int i=0;i<httpHeader.length;i++)
            {
                httpOut[i] = httpHeader[i];
            }

            int j=httpHeader.length;
            for(int i=0;i<dataOut.length;i++)
            {
                httpOut[j++] = dataOut[i];
            }

        }
        return httpOut;
    }

    public static String createXMLHeader(int contentLength)
    {    
        StringBuffer sb =new StringBuffer();

        sb.append("POST URL"+"HTTP/1.1").append(separator);
        sb.append("Host: "+"localhost" + ":"+"portno").append(separator);
        sb.append("Content-Type: text/xml").append(separator);
        sb.append("Content-Length: "+contentLength).append(separator);
        sb.append("Pragma: no-cache").append(separator);
        sb.append("Cache-Control: no-cache").append(separator);
        sb.append(separator);

        System.out.println(sb.toString());

        return sb.toString();
    }

    public static String byteArrayInputStringToString(ByteArrayInputStream is)
    {
        int size = is.available();
        char[] theChars = new char[size];
        byte[] bytes = new byte[size];

        is.read(bytes, 0,size);
        for(int i=0;i<size;)
            theChars[i] = (char)(bytes[i++]&0xff);

        return new String(theChars);
    }
    
    public void HTTPSMethod(File f, KeyUniqueIDMap k, Connection connection)
    {

        try{

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String i;
            String request = "";
            while((i= br.readLine())!=null)
            {
                request+= i;
            }

            System.out.println("************************REQUEST SENT TO SERVER**********************");
            
            
            outputStream = connection.socket.getOutputStream();
            //outTRIAL = new DataOutputStream(outputStream);
            outputStream.write(getXMLOutMessage(request.getBytes("UTF-8")));
            outputStream.flush();
            //outTRIAL.write(getXMLOutMessage(request.getBytes("UTF-8")));
            //outTRIAL.flush();
            
            //outTRIAL = new DataOutputStream(connection.socket.getOutputStream());
            //ByteArrayInputStream b = new ByteArrayInputStream(getXMLOutMessage(request.getBytes("UTF-8")));
            //outTRIAL.writeUTF(request);
            //outTRIAL.flush();

            Thread.sleep(2000);

            inputStream = connection.socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String line = "'";
            String httpProtocolStr = "XML";
            String responseCode = "";
            int contentLength = 0;

            try{

                while(!(line = dataInputStream.readLine()).equals(""))
                {
                    System.out.println("Received from server ******************************"+line);
                    if(line.contains(httpProtocolStr))
                    {
                        responseCode = line.substring(httpProtocolStr.length()+2);
                        if(!responseCode.contains("200"))
                        {
                            System.out.println("Response is not OK");
                        }
                    }
                    else if(line.contains("Content-Length"))
                    {
                        String[] parts = line.split(":");
                        String contentLengthStr = parts[1].trim();

                        try
                        {
                            contentLength = Integer.valueOf(contentLengthStr);
                        }
                        catch(NumberFormatException e)
                        {
                            contentLength = -1;
                        }
                    }

                }
            }
            catch(Exception e)
            {
                
            }

            System.out.println("************************RESPONSE RECEIVED FROM SERVER**********************");
            System.out.println("Content Length : "+contentLength);

            //dataInputStream.flush();

            dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            if(contentLength<0)
            {
                System.out.println("Content Length unknown");
            }
            byte[] contentBytes = new byte[contentLength];
            dataInputStream.read(contentBytes);
            byteArrayInputStream = new ByteArrayInputStream(contentBytes);
            System.out.println(byteArrayInputStringToString(byteArrayInputStream));
            
        }

        catch(Exception e)
        {

        }
    }

    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.type, k.length);
        File f= createRequestMessage.createKeyRequestMessage(createKey);
        
        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        HTTPSMethod(f, k, connection);

        //faaltu experiment
        Path pathXMLFile=Paths.get("/home/soha/Documents/Response1.xml");
        Files.write(pathXMLFile,line.getBytes(),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //NOT WORKING FROM HERE ONWARDS
        File response =new File("/home/soha/Documents/Response1.xml");
        /*DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(line);*/
        
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(response, uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
        //return null;
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


    KeyUniqueIDMap get(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        GetKey getKey = new GetKey(k.uniqueIdentifier);
        File f = createRequestMessage.getKeyRequestMessage(getKey);

        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        /*
        try 
        {
            PrintWriter out = new PrintWriter(connection.socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.socket.getInputStream())))
            {
                Scanner scanner = new Scanner(System.in);
                fr = new FileReader(f);
                br = new BufferedReader(fr);    
                String i;
                String request="";    
                while((i=br.readLine())!=null)    
                    request+= i;

                System.out.println("******************REQUEST SENT TO SERVER***************");
                out.println(request);
                Thread.sleep(2000);
                line = bufferedReader.readLine();
                System.out.println("*****************RESPONSE RECEIVED FROM SERVER****************");
                System.out.println(line);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        } 
        */

        HTTPSMethod(f, k, connection);

        //faaltu experiment
        Path pathXMLFile=Paths.get("/home/soha/Documents/Response1.xml");
        Files.write(pathXMLFile,line.getBytes(),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //NOT WORKING FROM HERE ONWARDS
        File response =new File("/home/soha/Documents/Response1.xml");
        /*DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(line);*/
        
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();
        
        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
        uid.add("KeyFormatType");
        uid.add("KeyMaterial");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(response, uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
        //return null;
    }

    KeyUniqueIDMap destroy(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        DestroyKey destroyKey = new DestroyKey(k.uniqueIdentifier);
        File f = createRequestMessage.destroyKeyRequestMessage(destroyKey);

        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        /*try 
        {
            PrintWriter out = new PrintWriter(connection.socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.socket.getInputStream())))
            {
                Scanner scanner = new Scanner(System.in);
                fr = new FileReader(f);
                br = new BufferedReader(fr);    
                String i;
                String request="";    
                while((i=br.readLine())!=null)    
                    request+= i;

                System.out.println("******************REQUEST SENT TO SERVER***************");
                out.println(request);
                Thread.sleep(2000);
                line = bufferedReader.readLine();
                System.out.println("*****************RESPONSE RECEIVED FROM SERVER****************");
                System.out.println(line);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        } 
        */

        HTTPSMethod(f, k, connection);

        //faaltu experiment
        Path pathXMLFile=Paths.get("/home/soha/Documents/Response1.xml");
        Files.write(pathXMLFile,line.getBytes(),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //NOT WORKING FROM HERE ONWARDS
        File response =new File("/home/soha/Documents/Response1.xml");
        /*DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(line);*/
        
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(response, uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    }

}
