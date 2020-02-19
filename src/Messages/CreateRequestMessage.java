package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import Attributes.Attribute;
import ClientInterfaces.CreateKey;
import ClientInterfaces.GetKey;
import ClientInterfaces.*;
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
    XMLTag CryptographicAlgorithm;
    XMLTag CryptographicLength;
    XMLTag CryptographicUsageMask;
    XMLTag UniqueIdentifier;
    XMLTag KeyFormatType;


    RequestHeader requestHeader;

    List<Object> attributes;

    //trial
    List<JAXBElement<Object>> attributes1;
    
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
    
        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enumeration), new KMIPTextString(createKey.getTypeOfKey()));
        
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

        /*Attribute attribute1 = new Attribute(new XMLTag("VendorIdentification", new EnumTag(EnumTag.VendorIdentification), new EnumType(EnumType.TextString), new KMIPTextString("x")),
        new XMLTag("AttributeName",new EnumTag(EnumTag.AttributeName) , new EnumType(EnumType.TextString),new KMIPTextString("ID")),
        new XMLTag("AttributeValue",new EnumTag(EnumTag.AttributeValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20-key1"))); 
        */
        CryptographicAlgorithm = new XMLTag("CryptographicAlgorithm", new EnumTag(EnumTag.CryptographicAlgorithm), new EnumType(EnumType.Enumeration), new KMIPTextString(createKey.getAlgorithm()));
        CryptographicLength = new XMLTag("CryptographicLength", new EnumTag(EnumTag.CryptographicLength), new EnumType(EnumType.Integer), new KMIPInteger(String.valueOf(createKey.getLength())));
        CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Decrypt Encrypt"));

        attributes = new ArrayList<Object>();
        /*attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);
        attributes.add(attribute6);
        */

        attributes.add(attribute);
        //attributes.add(attribute1);
        attributes.add(CryptographicAlgorithm);
        attributes.add(CryptographicLength);
        attributes.add(CryptographicUsageMask);


        //trial
        attributes1 = new ArrayList<JAXBElement<Object>>();

        attributes1.add(new JAXBElement(new QName("Attribute"),Attribute.class, attribute));
        attributes1.add(new JAXBElement(new QName("CryptographicAlgorithm"),XMLTag.class, CryptographicAlgorithm));
        attributes1.add(new JAXBElement(new QName("CryptographicLength"),XMLTag.class, CryptographicLength));
        attributes1.add(new JAXBElement(new QName("CryptographicUsageMask"),XMLTag.class, CryptographicUsageMask));

        requestPayload = new RequestPayload(ObjectType, attributes1);

        //requestPayload = new RequestPayload(ObjectType, attributes);

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

    public File getKeyRequestMessage(GetKey getKey) throws JAXBException
    {
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-PKCS12-1-20 step=8"));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Get"));

        //UniqueBatchItemID = new XMLTag("UniqueBatchItemID", new EnumTag(EnumTag.UniqueBatchItemId), new EnumType(EnumType.ByteString), new KMIPByteString("$UNIQUE_IDENTIFIER_1"));
    
        UniqueIdentifier = new XMLTag("UniqueIdentifier", new EnumTag(EnumTag.UniqueIdentifier), new EnumType(EnumType.TextString), new KMIPTextString(getKey.getUniqueIdentifier()));

        KeyFormatType = new XMLTag("KeyFormatType", new EnumTag(EnumTag.KeyFormatType), new EnumType(EnumType.Enumeration), new KMIPTextString("PKCS_12"));

        requestPayload = new RequestPayload(UniqueIdentifier, KeyFormatType);

        requestBatchItem = new RequestBatchItem(Operation, requestPayload);

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

    public File destroyKeyRequestMessage(DestroyKey destroyKey) throws JAXBException
    {
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20 step=6"));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));

        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Destroy"));

        UniqueBatchItemID = new XMLTag("UniqueBatchItemID", new EnumTag(EnumTag.UniqueBatchItemId), new EnumType(EnumType.ByteString), new KMIPByteString("01"));
        
        UniqueIdentifier = new XMLTag("UniqueIdentifier", new EnumTag(EnumTag.UniqueIdentifier), new EnumType(EnumType.TextString), new KMIPTextString(destroyKey.getUniqueIdentifier()));

        requestPayload = new RequestPayload(UniqueIdentifier);

        requestBatchItem = new RequestBatchItem(Operation,UniqueBatchItemID,requestPayload);

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
