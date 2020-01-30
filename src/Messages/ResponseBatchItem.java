package Messages;

import Enum.EnumOperation;
import Enum.EnumResultStatus;
import KMIPTypes.KMIPByteString;
import Objects.XMLTag;


//extends BatchItem
public class ResponseBatchItem  extends BatchItem
{
	ResponsePayload responsePayload;
	
	public ResponseBatchItem(XMLTag operation, XMLTag uniqueBatchItemId, ResponsePayload responsePayload) {
		 super(operation, uniqueBatchItemId);
		 this.responsePayload = responsePayload;
	 	// TODO Auto-generated constructor stub
	 }

	// EnumResultStatus resultStatus;
	// ResponsePayload responsePayload;

}
