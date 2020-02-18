package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import Attributes.Attribute;
import ClientInterfaces.CreateKey;
import Enum.EnumTag;
import Enum.EnumType;
import Objects.ProtocolVersion;
import Objects.XMLTag;
import KMIPTypes.*;
import Messages.KMIPRequestMessage;

import java.io.*;
import java.lang.*;

public class CreateRequestMessage {

    ProtocolVersion protocolVersion;

    XMLTag ProtocolVersionMajor;
    XMLTag ProtocolVersionMinor;
    XMLTag ClientCorrelationValue;
    XMLTag BatchOrderOption;
    XMLTag BatchCount;
    XMLTag Operation;
    XMLTag UniqueBatchItemID;
    XMLTag ObjectType;

    RequestHeader requestHeader;

    List<Object> attributes;
    Attribute attribute;

    RequestBatchItem requestBatchItem;
    List<RequestBatchItem> batchItems;

    RequestPayload requestPayload;

    KMIPRequestMessage requestMessage;

    public CreateRequestMessage()
    {

    }

    public File createKeyRequestMessage(CreateKey createKey) throws JAXBException
    {
        //KMIP v2.0
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20"));
    
        //There is not BatchOrderOption tag??? - DONE
        //BatchOrderOption = new XMLTag("BatchOrderOption", new EnumTag(EnumTag.BatchOrderOption), new EnumType(EnumType.Boolean), new KMIPBoolean(true));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        //DOUBT - EnumOperation? - DONE
        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Create"));

        UniqueBatchItemID = new XMLTag("UniqueBatchItemID", new EnumTag(EnumTag.UniqueBatchItemId), new EnumType(EnumType.ByteString), new KMIPByteString("01"));
    
        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enumeration), new KMIPTextString("SymmetricKey"));
        
        /*Attribute attribute1 = new Attribute("CryptographicLength", new KMIPInteger("128"), new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicLength));
        Attribute attribute2 = new Attribute("CryptographicAlgorithm", new KMIPTextString("AES"), new EnumType(EnumType.Enumeration), new EnumTag(EnumTag.CryptographicAlgorithm));
        Attribute attribute3 = new Attribute("CryptographicUsageMask", new KMIPTextString("Decrypt Encrypt"), new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicUsageMask));
        */
        /*Attribute attribute4 = new Attribute("VendorIdentification", new KMIPTextString("x"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.VendorIdentification));
        Attribute attribute5 = new Attribute("AttributeName", new KMIPTextString("ID"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.AttributeName));
        Attribute attribute6 = new Attribute("AttributeValue", new KMIPTextString("TC-OFFSET-1-20-key1"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.AttributeValue));
        */
        Attribute attribute = new Attribute(new XMLTag("VendorIdentification", new EnumTag(EnumTag.VendorIdentification), new EnumType(EnumType.TextString), new KMIPTextString("x")),
                                            new XMLTag("AttributeName",new EnumTag(EnumTag.AttributeName) , new EnumType(EnumType.TextString),new KMIPTextString("ID")),
                                            new XMLTag("AttributeValue",new EnumTag(EnumTag.AttributeValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20-key1"))); 

        XMLTag CryptographicAlgorithm = new XMLTag("CryptographicAlgorithm", new EnumTag(EnumTag.CryptographicAlgorithm), new EnumType(EnumType.Enumeration), new KMIPTextString("AES"));
        XMLTag CryptographicLength = new XMLTag("CryptographicLength", new EnumTag(EnumTag.CryptographicLength), new EnumType(EnumType.Integer), new KMIPInteger("128"));
        XMLTag CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Decrypt Encrypt"));

        attributes = new ArrayList<Object>();
        /*attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);
        attributes.add(attribute6);
        */
        
        attributes.add(attribute);
        attributes.add(CryptographicAlgorithm);
        attributes.add(CryptographicLength);
        attributes.add(CryptographicUsageMask);

        requestPayload = new RequestPayload(ObjectType, attributes);

        requestBatchItem = new RequestBatchItem(Operation, UniqueBatchItemID, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        //Working!
        File file = new File("/home/soha/Documents/Gheee.xml");
    
        final JAXBContext context = JAXBContext.newInstance(KMIPRequestMessage.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        //Working!
        marshaller.marshal(requestMessage, file);
        
        marshaller.marshal(requestMessage, System.out);
        
        return file;
    }
   

    /*public static void main(String[] args) throws JAXBException {
        
        CreateRequestMessage createRequestMessage = new CreateRequestMessage();
        createRequestMessage.createKeyRequestMessage();
        //System.out.println(createRequestMessage.requestMessage.toString());
    }*/
        
}
