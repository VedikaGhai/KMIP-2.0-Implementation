package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import Attributes.Attribute;
import Attributes.CommonAttributes;
import Attributes.Name;
import Attributes.PrivateKeyAttributes;
import Attributes.PublicKeyAttributes;
import ClientInterfaces.CreateKey;
import ClientInterfaces.GetKey;
import ClientInterfaces.*;
import Enum.EnumTag;
import Enum.EnumType;
import Objects.ProtocolVersion;
import Objects.XMLTag;
import KMIPTypes.*;

import java.io.*;
import java.text.ParseException;

//@XmlSeeAlso(Name.class)
public class CreateRequestMessage 
{

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
    XMLTag ActivationDate;
    Name name;

    RequestHeader requestHeader;

    List<Object> attributes;

    List<JAXBElement<Object>> attributes1;

    Attribute attribute;

    RequestBatchItem requestBatchItem;
    List<RequestBatchItem> batchItems;

    RequestPayload requestPayload;

    KMIPRequestMessage requestMessage;

    final String REQUEST_FILENAME = "/home/soha/Documents/Gheee.xml";

    public CreateRequestMessage() {

    }

    public File savingRequestMsgToFile() throws JAXBException, ParseException
    {
        File file = new File(REQUEST_FILENAME);
    
        final JAXBContext context = JAXBContext.newInstance(KMIPRequestMessage.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty("jaxb.fragment",Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        //Working!
        marshaller.marshal(requestMessage, file);
        
        marshaller.marshal(requestMessage, System.out);
        
        return file;
    }

    public File createKeyRequestMessage(CreateKey createKey) throws JAXBException, ParseException
    {
        //KMIP v2.0
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-REKEY-1-20-original"));
    
        //There is not BatchOrderOption tag??? - DONE
        //BatchOrderOption = new XMLTag("BatchOrderOption", new EnumTag(EnumTag.BatchOrderOption), new EnumType(EnumType.Boolean), new KMIPBoolean(true));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        //DOUBT - EnumOperation? - DONE
        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Create"));

        //FOR NOW UniqueBatchItemID = new XMLTag("UniqueBatchItemID", new EnumTag(EnumTag.UniqueBatchItemId), new EnumType(EnumType.ByteString), new KMIPByteString("1"));
    
        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enumeration), new KMIPTextString(createKey.getTypeOfKey()));
        
        /*Attribute attribute1 = new Attribute("CryptographicLength", new KMIPInteger("128"), new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicLength));
        Attribute attribute2 = new Attribute("CryptographicAlgorithm", new KMIPTextString("AES"), new EnumType(EnumType.Enumeration), new EnumTag(EnumTag.CryptographicAlgorithm));
        Attribute attribute3 = new Attribute("CryptographicUsageMask", new KMIPTextString("Decrypt Encrypt"), new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicUsageMask));
        */
        /*Attribute attribute4 = new Attribute("VendorIdentification", new KMIPTextString("x"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.VendorIdentification));
        Attribute attribute5 = new Attribute("AttributeName", new KMIPTextString("ID"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.AttributeName));
        Attribute attribute6 = new Attribute("AttributeValue", new KMIPTextString("TC-OFFSET-1-20-key1"), new EnumType(EnumType.TextString), new EnumTag(EnumTag.AttributeValue));
        */
        
        /*Attribute attribute = new Attribute(new XMLTag("VendorIdentification", new EnumTag(EnumTag.VendorIdentification), new EnumType(EnumType.TextString), new KMIPTextString("x")),
                                            new XMLTag("AttributeName",new EnumTag(EnumTag.AttributeName) , new EnumType(EnumType.TextString),new KMIPTextString("ID")),
                                            new XMLTag("AttributeValue",new EnumTag(EnumTag.AttributeValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20-key1"))); 
        */
        
        CryptographicAlgorithm = new XMLTag("CryptographicAlgorithm", new EnumTag(EnumTag.CryptographicAlgorithm), new EnumType(EnumType.Enumeration), new KMIPTextString(createKey.getAlgorithm()));
        CryptographicLength = new XMLTag("CryptographicLength", new EnumTag(EnumTag.CryptographicLength), new EnumType(EnumType.Integer), new KMIPInteger(String.valueOf(createKey.getLength())));
        CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Decrypt Encrypt"));
        //ActivationDate = new XMLTag("ActivationDate", new EnumTag(EnumTag.ActivationDate),new EnumType(EnumType.DateTime),new KMIPDateTime("$NOW-3600"));

        name = new Name(new XMLTag("NameValue", new EnumTag(EnumTag.NameValue), new EnumType(EnumType.TextString),new KMIPTextString("TC-REKEY-1-20-original")),new XMLTag("NameType",new EnumTag(EnumTag.NameType), new EnumType(EnumType.Enumeration),new KMIPTextString("UninterpretedTextString")));

        /*NOT USING
        attributes = new ArrayList<Object>();
        /*attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);
        attributes.add(attribute6);
        

        attributes.add(attribute);
        //attributes.add(attribute1);
        attributes.add(CryptographicAlgorithm);
        attributes.add(CryptographicLength);
        attributes.add(CryptographicUsageMask);
        //attributes.add(name);
        */

        //trial
        attributes1 = new ArrayList<JAXBElement<Object>>();


        //attributes1.add(new JAXBElement(new QName("Attribute"),Attribute.class, attribute));
        //attributes1.add(new JAXBElement(new QName("Name"),Name.class, name));
        attributes1.add(new JAXBElement(new QName("CryptographicAlgorithm"),XMLTag.class, CryptographicAlgorithm));
        attributes1.add(new JAXBElement(new QName("CryptographicLength"),XMLTag.class, CryptographicLength));
        attributes1.add(new JAXBElement(new QName("CryptographicUsageMask"),XMLTag.class, CryptographicUsageMask));
        //attributes1.add(new JAXBElement(new QName("ActivationDate"),XMLTag.class, ActivationDate));
        //System.out.println(name.toString());

        requestPayload = new RequestPayload(ObjectType, attributes1);

        //requestPayload = new RequestPayload(ObjectType, attributes);

        //FOR NOW requestBatchItem = new RequestBatchItem(Operation, UniqueBatchItemID ,requestPayload);
        requestBatchItem = new RequestBatchItem(Operation, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        return savingRequestMsgToFile();
    }

    public File getKeyRequestMessage(GetKey getKey) throws JAXBException, ParseException
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

        //KeyFormatType = new XMLTag("KeyFormatType", new EnumTag(EnumTag.KeyFormatType), new EnumType(EnumType.Enumeration), new KMIPTextString("Raw"));

        requestPayload = new RequestPayload(UniqueIdentifier);

        requestBatchItem = new RequestBatchItem(Operation, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        return savingRequestMsgToFile();

    }

    public File destroyKeyRequestMessage(DestroyKey destroyKey) throws JAXBException, ParseException
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
        
        return savingRequestMsgToFile();
    }

    public File setAttributeRequestMessage(SetAttribute setAttribute) throws JAXBException
    {
        //KMIP v2.0
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, BatchCount);

        //DOUBT - EnumOperation? - DONE
        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Register"));

        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enumeration), new KMIPTextString(setAttribute.getTypeOfKey()));
        
        CryptographicAlgorithm = new XMLTag("CryptographicAlgorithm", new EnumTag(EnumTag.CryptographicAlgorithm), new EnumType(EnumType.Enumeration), new KMIPTextString(setAttribute.getAlgorithm()));
        CryptographicLength = new XMLTag("CryptographicLength", new EnumTag(EnumTag.CryptographicLength), new EnumType(EnumType.Integer), new KMIPInteger(String.valueOf(setAttribute.getLength())));
        CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Decrypt Encrypt"));
        //ActivationDate = new XMLTag("ActivationDate", new EnumTag(EnumTag.ActivationDate),new EnumType(EnumType.DateTime),new KMIPTextString("$NOW-3600"));

        //name = new Name(new XMLTag("NameValue", new EnumTag(EnumTag.NameValue), new EnumType(EnumType.TextString),new KMIPTextString("TC-REKEY-1-20-original")),new XMLTag("NameType",new EnumTag(EnumTag.NameType), new EnumType(EnumType.Enumeration),new KMIPTextString("UninterpretedTextString")));

        attributes = new ArrayList<Object>();
        /*attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);
        attributes.add(attribute6);
        */

        //attributes.add(attribute);
        attributes.add(CryptographicAlgorithm);
        attributes.add(CryptographicLength);
        attributes.add(CryptographicUsageMask);
        
        //trial
        attributes1 = new ArrayList<JAXBElement<Object>>();


        //attributes1.add(new JAXBElement(new QName("Attribute"),Attribute.class, attribute));
        //attributes1.add(new JAXBElement(new QName("Name"),Name.class,name));
        attributes1.add(new JAXBElement(new QName("CryptographicAlgorithm"),XMLTag.class, CryptographicAlgorithm));
        attributes1.add(new JAXBElement(new QName("CryptographicLength"),XMLTag.class, CryptographicLength));
        attributes1.add(new JAXBElement(new QName("CryptographicUsageMask"),XMLTag.class, CryptographicUsageMask));
        //System.out.println(name.toString());


        //TO ADD - SymmetricKey tag (with KeyFormatType and KeyMaterial)


        requestPayload = new RequestPayload(ObjectType, attributes1);

        //requestPayload = new RequestPayload(ObjectType, attributes);

        requestBatchItem = new RequestBatchItem(Operation, UniqueBatchItemID ,requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        //Working!
        File file = new File("/home/soha/Documents/Gheee.xml");
    
        final JAXBContext context = JAXBContext.newInstance(KMIPRequestMessage.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty("jaxb.fragment",Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        //Working!
        marshaller.marshal(requestMessage, file);
        
        marshaller.marshal(requestMessage, System.out);
        
        return file;
    }

    public File locateKeyRequestMessage(LocateKey locateKey) throws JAXBException, ParseException
    {
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-OFFSET-1-20 step=6"));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));

        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("Locate"));
        
        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enumeration), new KMIPTextString(locateKey.getTypeOfKey()));

        attributes1 = new ArrayList<JAXBElement<Object>>();
        attributes1.add(new JAXBElement(new QName("ObjectType"),XMLTag.class, ObjectType));

        requestPayload = new RequestPayload(attributes1);
        
        requestBatchItem = new RequestBatchItem(Operation, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        return savingRequestMsgToFile();
    }    

    
    public File createKeyPairRequestMessage(CreateKeyPair createKeyPair) throws JAXBException, ParseException
    {
        //KMIP v2.0
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("AKLC-M-1-20 step=0"));
    
        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchCount);

        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enumeration), new KMIPTextString("CreateKeyPair"));
        
        CryptographicAlgorithm = new XMLTag("CryptographicAlgorithm", new EnumTag(EnumTag.CryptographicAlgorithm), new EnumType(EnumType.Enumeration), new KMIPTextString(createKeyPair.getAlgorithm()));
        CryptographicLength = new XMLTag("CryptographicLength", new EnumTag(EnumTag.CryptographicLength), new EnumType(EnumType.Integer), new KMIPInteger(String.valueOf(createKeyPair.getLength())));
        CommonAttributes commonAttributes = new CommonAttributes(CryptographicAlgorithm, CryptographicLength);

        name = new Name(new XMLTag("NameValue", new EnumTag(EnumTag.NameValue), new EnumType(EnumType.TextString),new KMIPTextString(createKeyPair.getPrivateKeyNameValue())),new XMLTag("NameType",new EnumTag(EnumTag.NameType), new EnumType(EnumType.Enumeration),new KMIPTextString("UninterpretedTextString")));
        CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Sign"));
        PrivateKeyAttributes privateKeyAttributes = new PrivateKeyAttributes(name, CryptographicUsageMask);

        name = new Name(new XMLTag("NameValue", new EnumTag(EnumTag.NameValue), new EnumType(EnumType.TextString),new KMIPTextString(createKeyPair.getPublicKeyNameValue())), new XMLTag("NameType",new EnumTag(EnumTag.NameType), new EnumType(EnumType.Enumeration),new KMIPTextString("UninterpretedTextString")));
        CryptographicUsageMask = new XMLTag("CryptographicUsageMask", new EnumTag(EnumTag.CryptographicUsageMask), new EnumType(EnumType.Integer), new KMIPTextString("Verify"));
        PublicKeyAttributes publicKeyAttributes = new PublicKeyAttributes(name, CryptographicUsageMask);
        
        attributes1 = new ArrayList<JAXBElement<Object>>();

        attributes1.add(new JAXBElement(new QName("CommonAttributes"), CommonAttributes.class, commonAttributes));
        attributes1.add(new JAXBElement(new QName("PrivateKeyAttributes"), PrivateKeyAttributes.class, privateKeyAttributes));
        attributes1.add(new JAXBElement(new QName("PublicKeyAttributes"), PublicKeyAttributes.class, publicKeyAttributes));
        

        requestPayload = new RequestPayload(commonAttributes, privateKeyAttributes, publicKeyAttributes);

        requestBatchItem = new RequestBatchItem(Operation, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        return savingRequestMsgToFile();
    }
    


   

    /*public static void main(String[] args) throws JAXBException {
        
        CreateRequestMessage createRequestMessage = new CreateRequestMessage();
        createRequestMessage.createKeyRequestMessage();
        //System.out.println(createRequestMessage.requestMessage.toString());
    }*/
        
}
