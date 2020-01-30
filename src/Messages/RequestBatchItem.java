package Messages;

import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement
public class RequestBatchItem extends BatchItem 
{

	RequestPayload requestPayload;

	public RequestBatchItem(){
		
	}

	public RequestBatchItem(XMLTag operation, XMLTag uniqueBatchItemId, RequestPayload requestPayload) {
		super(operation, uniqueBatchItemId);
		this.requestPayload =  requestPayload;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RequestBatchItem [requestPayload=" + requestPayload + "]";
	}


}
