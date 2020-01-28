package Messages;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class KMIPRequestMessage {
	
	RequestHeader requestHeader;
	List<RequestBatchItem> batchItems;

	public KMIPRequestMessage(){

	}
	//Request Message setter
	public KMIPRequestMessage(RequestHeader requestHeader, List<RequestBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<RequestBatchItem>();
		this.requestHeader = requestHeader;
		this.batchItems = batchItems;
	}

	//Resquest Header getter
	@XmlElement
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	//Request Header setter
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	//Request Message Batch Items getter
	@XmlElement
	public List<RequestBatchItem> getBatchItems() {
		return batchItems;
	}

	//Request Message Batch Items setter
	public void setBatchItems(List<RequestBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

	@Override
	public String toString() {
		return "KMIPRequestMessage [batchItems=" + batchItems + ", requestHeader=" + requestHeader + "]";
	}

}
