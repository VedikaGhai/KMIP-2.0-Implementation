package Messages;

import java.util.ArrayList;
import java.util.List;

public class KMIPRequestMessage {
	RequestHeader requestHeader;
	List<RequestBatchItem> batchItems;

	//Request Message setter
	public KMIPRequestMessage(RequestHeader requestHeader, List<RequestBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<RequestBatchItem>();
		this.requestHeader = requestHeader;
		this.batchItems = batchItems;
	}

	//Resquest Header getter
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	//Request Header setter
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	//Request Message Batch Items getter
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
