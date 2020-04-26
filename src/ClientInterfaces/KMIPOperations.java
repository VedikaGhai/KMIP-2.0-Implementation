package ClientInterfaces;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import Messages.CreateRequestMessage;
import Operations.DecodeResponseMessage;

/**
 * This class establishes connection with the key management server, sends request message, receives response message and
 * sends it to DOM Parser for extracing important information from it.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see Connection
 * @see KeyUniqueIDMap
 * @see CreateRequestMessage
 * @see DecodeResponseMessage
 */
public class KMIPOperations
{
    //call the desired operation class and its methods
    //int port = 5000;
    FileReader fr;
    BufferedReader br;
    File f2;

    String responseMessage = "";
    final String RESPONSE_FILENAME = "ResponseMessage.xml";
    File response;
    
    String line="";
    
    OutputStream outputStream;
    DataOutputStream outTRIAL;

    InputStream inputStream;
    DataInputStream dataInputStream;
    ByteArrayInputStream byteArrayInputStream;

    /**
     * Default constructor
     */
    public KMIPOperations() 
    {
        
    }

    private static String separator = System.getProperty("line.separator");

    /**
     * This method forms the complete request message (HTTP Header + the actual XML Request Message)
     * @param dataOut the request message.
     * @return {@code byte[]} the combined request message is returned.
     */
    public static byte[] getXMLOutMessage(byte[] dataOut, Connection connection)
    {
        byte[] httpHeader = null;
        byte[] httpOut = null;
        if(dataOut!=null)
        {
            httpHeader = createXMLHeader(dataOut.length, connection).getBytes();
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

    /**
     * This method creates the HTTP header.
     * @param contentLength total length of the XML Request Message
     * @return String the formed HTTP header
     */
    public static String createXMLHeader(int contentLength, Connection connection)
    {    
        StringBuffer sb =new StringBuffer();

        sb.append("POST /ibm/sklm/KMIPServlet"+"HTTP/1.1").append(separator);
        //sb.append("Host: "+"169.57.202.148" + ":"+"5696").append(separator);
        sb.append("Host: "+connection.ip + ":"+connection.port).append(separator);
        sb.append("Content-Type: text/xml").append(separator);
        sb.append("Content-Length: "+contentLength).append(separator);
        sb.append("Pragma: no-cache").append(separator);
        sb.append("Cache-Control: no-cache").append(separator);
        sb.append(separator);

        System.out.println(sb.toString());

        return sb.toString();
    }
    
    /**
     * This method converts byte array input to string.
     * @param is ByteArrayInputStream object
     * @return String 
     * @see ByteArrayInputStream
     */
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
    
    /**
     * This method sends the request (received in a file) to the server,
     * received response message from the server,
     * separates the response message from the response's HTTP header, 
     * writes the response message to a file.
     * @param f File which has the request message combined with the HTTP header.
     * @param k KeyUniqueIDMap object.
     * @param connection Connection object which contains the socket and the IP and port number of the server.
     */
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
            outputStream.write(getXMLOutMessage(request.getBytes("UTF-8"), connection));
            /*String requestNEW = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><RequestMessage>" + "<RequestHeader>"
				+ "<ProtocolVersion>" + "<ProtocolVersionMajor type=\"Integer\" value=\"2\"/>"
				+ "<ProtocolVersionMinor type=\"Integer\" value=\"0\"/>" + "</ProtocolVersion>"
				+ "<BatchCount type=\"Integer\" value=\"1\"/>" + "</RequestHeader>" + "<BatchItem>"
				+ "<Operation type=\"Enumeration\" value=\"Create\"/>" + "<RequestPayload>"
				+ "<ObjectType type=\"Enumeration\" value=\"SymmetricKey\"/>" + "<TemplateAttribute>" + "<Attribute>"
				+ "<AttributeName type=\"TextString\" value=\"Name\"/>" + "<AttributeValue>"
				+ "<NameValue  type=\"TextString\" value=\"TC-REKEY-1-20-original\"/>"
				+ "<NameType type=\"Enumeration\" value=\"UninterpretedTextString\"/>" + "</AttributeValue>"
				+ "</Attribute>" + "<Attribute>"
				+ "<AttributeName type=\"TextString\" value=\"Cryptographic Algorithm\"/>"
				+ "<AttributeValue type=\"Enumeration\" value=\"AES\"/>" + "</Attribute>" + "<Attribute>"
				+ "<AttributeName type=\"TextString\" value=\"Cryptographic Length\"/>"
				+ "<AttributeValue type=\"Integer\" value=\"128\"/>" + "</Attribute>" + "<Attribute>"
				+ "<AttributeName type=\"TextString\" value=\"Cryptographic Usage Mask\"/>"
				+ "<AttributeValue type=\"Integer\" value=\"Decrypt Encrypt\"/>" + "</Attribute>"
				+ "</TemplateAttribute>" + "</RequestPayload>" + "</BatchItem>" + "</RequestMessage>";
            outputStream.write(getXMLOutMessage(requestNEW.getBytes("UTF-8")));*/
            
            outputStream.flush();
            //outTRIAL.write(getXMLOutMessage(request.getBytes("UTF-8")));
            //outTRIAL.flush();

            Thread.sleep(2000);

            inputStream = connection.socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);

            line = "'";
            String httpProtocolStr = "text/xml";
            String responseCode = "";
            int contentLength = 0;

            try{

                //while(!(line=triallll.readLine()).equals(""))
                while(!(line = dataInputStream.readLine()).equals(""))
                {
                    System.out.println("Received from server ******************************"+line);
                    if(line.contains(httpProtocolStr))
                    {
                        responseCode = line.substring(httpProtocolStr.length()+2);
                        System.out.println(responseCode);
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
            
            //printing the response message received from server, on the terminal
            responseMessage = byteArrayInputStringToString(byteArrayInputStream);
            System.out.println(responseMessage);

            //writing it to a file for further processing (DOM Parsing)
            FileWriter fw = new FileWriter(RESPONSE_FILENAME);
            fw.write(responseMessage);
            fw.flush();
            fw.close();

        }

        catch(Exception e)
        {

        }
    }

    /**
     * CreateKey operation method. Uses CreateRequestMessage's createKeyRequestMessage method to create
     * required request message, sends it to server via HTTPSMethod,
     * uses DecodeResponseMessage's methods to extract important information from the response message
     * @param k KeyUniqueIDMap object which contains information about the key wrapped with the key's UniqueIdentifier
     * @param connection Connection object, contains socket wrapped with IP and port number of server.
     * @return KeyUniqueIDMap object, which has key information wrapped with the information about key we extracted from response message.
     * @throws Exception
     */
    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.type, k.length);
        File f= createRequestMessage.createKeyRequestMessage(createKey);
        
        HTTPSMethod(f, k, connection);
        
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(new File(RESPONSE_FILENAME), uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    
    }

    /**
     * GetKey operation method. Uses CreateRequestMessage's getKeyRequestMessage method to create
     * required request message, sends it to server via HTTPSMethod,
     * uses DecodeResponseMessage's methods to extract important information from the response message
     * @param k KeyUniqueIDMap object which contains information about the key wrapped with the key's UniqueIdentifier
     * @param connection Connection object, contains socket wrapped with IP and port number of server.
     * @return KeyUniqueIDMap object, which has key information wrapped with the information about key we extracted from response message.
     * @throws Exception
     */
    KeyUniqueIDMap get(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        GetKey getKey = new GetKey(k.uniqueIdentifier);
        File f = createRequestMessage.getKeyRequestMessage(getKey);

        
        HTTPSMethod(f, k, connection);

        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();
        
        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
        uid.add("KeyFormatType");
        uid.add("KeyMaterial");
    
        List<String> uidResponse = new ArrayList<String>();

        //USING FILE
        uidResponse = decodeResponseMessage.DOMParser(new File(RESPONSE_FILENAME), uid);
        //USING STRING
        //uidResponse = decodeResponseMessage.DOMParser(responseMessage, uid);

        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    }

    /**
     * DestroyKey operation method. Uses CreateRequestMessage's destroyKeyRequestMessage method to create
     * required request message, sends it to server via HTTPSMethod,
     * uses DecodeResponseMessage's methods to extract important information from the response message
     * @param k KeyUniqueIDMap object which contains information about the key wrapped with the key's UniqueIdentifier
     * @param connection Connection object, contains socket wrapped with IP and port number of server.
     * @return KeyUniqueIDMap object, which has key information wrapped with the information about key we extracted from response message.
     * @throws Exception
     */
    KeyUniqueIDMap destroy(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        DestroyKey destroyKey = new DestroyKey(k.uniqueIdentifier);
        File f = createRequestMessage.destroyKeyRequestMessage(destroyKey);

        HTTPSMethod(f, k, connection);

        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(new File(RESPONSE_FILENAME), uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    }

    /**
     * LocateKey operation method. Uses CreateRequestMessage's locateKeyRequestMessage method to create
     * required request message, sends it to server via HTTPSMethod,
     * uses DecodeResponseMessage's methods to extract important information from the response message
     * @param k KeyUniqueIDMap object which contains information about the key wrapped with the key's UniqueIdentifier
     * @param connection Connection object, contains socket wrapped with IP and port number of server.
     * @return KeyUniqueIDMap object, which has key information wrapped with the information about key we extracted from response message.
     * @throws Exception
     */
    KeyUniqueIDMap locate(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        LocateKey locateKey = new LocateKey(k.getType());
        File f = createRequestMessage.locateKeyRequestMessage(locateKey);

        HTTPSMethod(f, k, connection);

        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("UniqueIdentifier");
    
        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(new File(RESPONSE_FILENAME), uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    }

    /**
     * CreateKeyPair operation method. Uses CreateRequestMessage's createKeyPairRequestMessage method to create
     * required request message, sends it to server via HTTPSMethod,
     * uses DecodeResponseMessage's methods to extract important information from the response message
     * @param k KeyUniqueIDMap object which contains information about the key wrapped with the key's UniqueIdentifier
     * @param connection Connection object, contains socket wrapped with IP and port number of server.
     * @return KeyUniqueIDMap object, which has key information wrapped with the information about key we extracted from response message.
     * @throws Exception
     */
    KeyUniqueIDMap createKeyPair(KeyUniqueIDMap k, Connection connection) throws Exception
    {           
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKeyPair createKeyPair=new CreateKeyPair(k.algorithm, k.type, k.length, k.privateKeyNameValue, k.publicKeyNameValue);
        File f= createRequestMessage.createKeyPairRequestMessage(createKeyPair);
        
        HTTPSMethod(f, k, connection);
        
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();

        List<String> uid = new ArrayList<String>();
        uid.add("PrivateKeyUniqueIdentifier");
        uid.add("PublicKeyUniqueIdentifier");
        
        //uid.add("UniqueIdentifier");

        List<String> uidResponse = new ArrayList<String>();
        uidResponse = decodeResponseMessage.DOMParser(new File(RESPONSE_FILENAME), uid);
        
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uidResponse);
        
        return responseUID;
    
    }
}
