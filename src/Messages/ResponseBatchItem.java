package Messages;

import Objects.XMLTag;

/**
 * ResponseBatchItem POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag 
 * @see BatchItem
 * @see ResponsePayload
 */ 
public class ResponseBatchItem  extends BatchItem
{
	ResponsePayload responsePayload;
	
	/**
	 * Parameterized constructor.
	 * @param operation operation tag (for a particular operation).
	 * @param uniqueBatchItemId ID for particular batch item.
	 * @param responsePayload response payload
	 */
	public ResponseBatchItem(XMLTag operation, XMLTag uniqueBatchItemId, ResponsePayload responsePayload) {
		 super(operation, uniqueBatchItemId);
		 this.responsePayload = responsePayload;
	 	// TODO Auto-generated constructor stub
	 }

}
