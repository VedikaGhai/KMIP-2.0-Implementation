package Messages;

import java.util.List;

public class KMIPRequestMessage {
	RequestHeader requestHeader;
	List<RequestBatchItem> batchItems;
	public KMIPRequestMessage(RequestHeader requestHeader, List<RequestBatchItem> batchItems) {
		super();
		this.requestHeader = requestHeader;
		this.batchItems = batchItems;
	}
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	public List<RequestBatchItem> getBatchItems() {
		return batchItems;
	}
	public void setBatchItems(List<RequestBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

}
