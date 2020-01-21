package ClientInterfaces;
import Messages.CreateRequestMessage;

public class KMIPOperations
{
    //call the desired operation class and its methods

    public KMIPOperations() 
    {
        
    }
    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection)
    {
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.typeOfKey, k.length);
        File f= createRequestmessage.createKeyRequestMessage(createKey);
        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        DataInputStream bis= new DataInputStream(new FileInputStream(f));
        DataOutputStream bout= new DataOutputStream(connection.socket.getOutputStream());
        bout.writeUTF(bis.readUTF());
        Thread.sleep(1000);
        DataInputStream dis=new DataInputStream(connection.socket.getInputStream());
        //String s= dis.readUTF();
        File response =new File("/home/soha/Documents/Response2.xml");
        DataOutputStream dout= new DataOutputStream(new FileOuptutStream(response));
        dout.writeUTF(dis.readUTF());
        DecodeReponseMessage decodeResponseMessage= new DecodeResponseMessage();
        String uniqueIdentifier = decodeResponseMessage.DOMParser();
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uniqueIdentifier);
        return responseUID;
    }
    
}

