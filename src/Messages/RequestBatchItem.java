package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

//@XmlRootElement
public class RequestBatchItem extends BatchItem 
{
	@XmlElement(name = "RequestPayload")
	RequestPayload requestPayload;

	public RequestBatchItem(){
		
	}

	public RequestBatchItem(XMLTag operation, XMLTag uniqueBatchItemId, RequestPayload requestPayload) {
		super(operation, uniqueBatchItemId);
		this.requestPayload =  requestPayload;
		// TODO Auto-generated constructor stub
	}

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
