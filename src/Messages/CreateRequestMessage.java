package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Attributes.Attribute;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPBoolean;
import KMIPTypes.KMIPByteString;
import KMIPTypes.KMIPInteger;
import KMIPTypes.KMIPTextString;
import Objects.ProtocolVersion;
import Objects.XMLTag;

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

    List<Attribute> attributes;
    Attribute attribute;

    RequestBatchItem requestBatchItem;
    List<RequestBatchItem> batchItems;

    RequestPayload requestPayload;

    KMIPRequestMessage requestMessage;

    public File createKeyRequestMessage(CreateKey createKey) throws JAXBException
    {
        //KMIP v2.0
        ProtocolVersionMajor = new XMLTag("ProtocolVersionMajor", new EnumTag(EnumTag.ProtocolVersionMajor), new EnumType(EnumType.Integer), new KMIPInteger("2"));
        ProtocolVersionMinor = new XMLTag("ProtocolVersionMinor", new EnumTag(EnumTag.ProtocolVersionMinor), new EnumType(EnumType.Integer), new KMIPInteger("0"));

        protocolVersion = new ProtocolVersion(ProtocolVersionMajor, ProtocolVersionMinor);

        ClientCorrelationValue = new XMLTag("ClientCorrelationValue", new EnumTag(EnumTag.ClientCorrelationValue), new EnumType(EnumType.TextString), new KMIPTextString("TC-CREATE-SD-1-20"));
    
        BatchOrderOption = new XMLTag("BatchOrderOption", new EnumTag(EnumTag.BatchOrderOption), new EnumType(EnumType.Boolean), new KMIPBoolean(true));

        BatchCount = new XMLTag("BatchCount", new EnumTag(EnumTag.BatchCount), new EnumType(EnumType.Integer), new KMIPInteger("1"));
    
        requestHeader = new RequestHeader(protocolVersion, ClientCorrelationValue, BatchOrderOption, BatchCount);

        //DOUBT - EnumOperation?
        Operation = new XMLTag("Operation", new EnumTag(EnumTag.Operation), new EnumType(EnumType.Enummeration), new KMIPTextString("Create"));

        UniqueBatchItemID = new XMLTag("UniqueBatchItemID", new EnumTag(EnumTag.UniqueBatchItemId), new EnumType(EnumType.ByteString), new KMIPByteString("01"));
    
        ObjectType = new XMLTag("ObjectType", new EnumTag(EnumTag.ObjectType), new EnumType(EnumType.Enummeration), new KMIPTextString("SecretData"));
        
        attribute = new Attribute("CryptographicLength", new KMIPInteger("80"), new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicLength));
        attributes = new ArrayList<Attribute>();
        attributes.add(attribute);

        requestPayload = new RequestPayload(ObjectType, attributes);

        requestBatchItem = new RequestBatchItem(Operation, UniqueBatchItemID, requestPayload);

        batchItems = new ArrayList<RequestBatchItem>();
        batchItems.add(requestBatchItem);

        requestMessage = new KMIPRequestMessage(requestHeader, batchItems);

        final JAXBContext context = JAXBContext.newInstance(KMIPRequestMessage.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(requestMessage, System.out);    
    }


    /*public static void main(String[] args) throws JAXBException {
        
        CreateRequestMessage createRequestMessage = new CreateRequestMessage();
        createRequestMessage.createKeyRequestMessage();
        //System.out.println(createRequestMessage.requestMessage.toString());
    }*/
        
}
