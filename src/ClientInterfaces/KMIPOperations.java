package ClientInterfaces;
import Messages.CreateRequestMessage;
import java.io.*;
import Operations.DecodeResponseMessage;
import Messages.CreateRequestMessage;


public class KMIPOperations
{
    //call the desired operation class and its methods

    public KMIPOperations() 
    {
        
    }
    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection) throws Exception
    {
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.type, k.length);
        File f= createRequestMessage.createKeyRequestMessage(createKey);
        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        DataInputStream bis= new DataInputStream(new FileInputStream(f));
        DataOutputStream bout= new DataOutputStream(connection.socket.getOutputStream());
        bout.writeUTF(bis.readUTF());
        Thread.sleep(1000);
        DataInputStream dis=new DataInputStream(connection.socket.getInputStream());
        //String s= dis.readUTF();
        File response =new File("/home/soha/Documents/Response2.xml");
        DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(dis.readUTF());
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();
        String uniqueIdentifier = decodeResponseMessage.DOMParser();
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uniqueIdentifier);

        bis.close();
        dout.close();

        return responseUID;
    }
    
}

