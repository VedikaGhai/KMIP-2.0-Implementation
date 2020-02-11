package Messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "RequestMessage") 
public class KMIPRequestMessage
{
	RequestHeader requestHeader;
	List<RequestBatchItem> batchItems;
	
	//@XmlAttribute(name="Name") - Working!
	//String hi = "Soha";

	public KMIPRequestMessage()
	{

	}

	//Request Message setter
	public KMIPRequestMessage(RequestHeader requestHeader, List<RequestBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<RequestBatchItem>();
		this.requestHeader = requestHeader;
		this.batchItems = batchItems;
	}

	/* Working!
	public String getString()
	{
		return hi;
	}*/

	//Resquest Header getter
	@XmlElement(name = "RequestHeader") //yes
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	//Request Header setter
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	//Request Message Batch Items getter
	@XmlElement(name = "BatchItem") //yes
	public List<RequestBatchItem> getBatchItems() {
		return batchItems;
	}

	//Request Message Batch Items setter
	public void setBatchItems(List<RequestBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

	/*@Override
	public String toString() {
		return "KMIPRequestMessage [requestHeader=" + requestHeader + ", batchItem=" + batchItems + "]";
	}*/
}
