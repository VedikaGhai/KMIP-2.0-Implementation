package Messages;

import Enum.EnumOperation;
import Enum.EnumResultStatus;
import KMIPTypes.KMIPByteString;
import Objects.XMLTag;


//extends BatchItem
public class ResponseBatchItem  extends BatchItem{
	public ResponseBatchItem(XMLTag operation, XMLTag uniqueBatchItemId) {
	 	super(operation, uniqueBatchItemId);
	 	// TODO Auto-generated constructor stub
	 }

	// EnumResultStatus resultStatus;
	// ResponsePayload responsePayload;

}
