package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * RequestBatchItem POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see BatchItem
 * @see XMLTag
 * @see RequestPayload
 */
public class RequestBatchItem extends BatchItem 
{
	@XmlElement(name = "RequestPayload")
	RequestPayload requestPayload;

	/**
	 * Default constructor.
	 */
	public RequestBatchItem(){
		
	}

	/**
	 * Parameterized constructor.
	 * @param operation operation, for eg. "Create".
	 * @param uniqueBatchItemId ID of a particular batch item.
	 * @param requestPayload request payload
	 */
	public RequestBatchItem(XMLTag operation, XMLTag uniqueBatchItemId, RequestPayload requestPayload) {
		super(operation, uniqueBatchItemId);
		this.requestPayload =  requestPayload;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor.
	 * @param Operation operation, for eg. "Create".
	 * @param requestPayload request payload.
	 */
	public RequestBatchItem(XMLTag Operation, RequestPayload requestPayload)
	{
		super(Operation, null);
		this.requestPayload=requestPayload;
	}

	@Override
	public String toString() {
		return "RequestBatchItem [requestPayload=" + requestPayload + "]";
	}


}
