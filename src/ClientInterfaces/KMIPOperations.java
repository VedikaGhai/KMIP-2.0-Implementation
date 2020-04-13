package ClientInterfaces;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import Messages.CreateRequestMessage;
import Operations.DecodeResponseMessage;

public class KMIPOperations
{
    //call the desired operation class and its methods
    //int port = 5000;
    FileReader fr;
    BufferedReader br;
    File f2;

    String responseMessage = "";
    final String RESPONSE_FILENAME = "/home/soha/Documents/Response1.xml";
    File response;
    
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

        sb.append("POST /ibm/sklm/KMIPServlet"+"HTTP/1.1").append(separator);
        sb.append("Host: "+"hostname" + ":"+"portno").append(separator);
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


    //Trial - String to document 
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
