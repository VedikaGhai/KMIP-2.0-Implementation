package Messages;
//import Enum.EnumObjectType;

import Keys.SymmetricKey;
import Objects.XMLTag;

public class ResponsePayload {

    XMLTag objectType;
    XMLTag uniqueIdentifier;
    SymmetricKey symmetricKey;

    /* 3 constructors because there are 3 cases we encountered while looking at ResponsePayload in ResponseMessage
     1. There is nothing in the ResponsePayload
     2. There is only ObjectType and UniqueIdentifier in the ResponsePayload
     3. There are all 3 - ObjectType, UnqiueIdentifier and SymmetricKey in the ResponsePayload
    */

    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier, SymmetricKey symmetricKey) {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
        this.symmetricKey = symmetricKey;
    }
    
    public ResponsePayload()
    {
        //default constuctor
    }
    
    public ResponsePayload(XMLTag objectType, XMLTag uniqueIdentifier)
    {
        this.objectType = objectType;
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
