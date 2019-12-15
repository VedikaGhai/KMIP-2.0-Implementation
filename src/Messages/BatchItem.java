package Messages;

import Enum.EnumOperation;
import KMIPTypes.KMIPByteString;

public class BatchItem {
	EnumOperation operation;
	KMIPByteString UniqueBatchItemId;
	RequestPayload requestPayLoad;
	public BatchItem(EnumOperation operation, KMIPByteString uniqueBatchItemId, RequestPayload requestPayLoad) {
		super();
		this.operation = operation;
		UniqueBatchItemId = uniqueBatchItemId;
		this.requestPayLoad = requestPayLoad;
	}
	public EnumOperation getOperation() {
		return operation;
	}
	public void setOperation(EnumOperation operation) {
		this.operation = operation;
	}
	public KMIPByteString getUniqueBatchItemId() {
		return UniqueBatchItemId;
	}
	public void setUniqueBatchItemId(KMIPByteString uniqueBatchItemId) {
		UniqueBatchItemId = uniqueBatchItemId;
	}
	public RequestPayload getRequestPayLoad() {
		return requestPayLoad;
	}
	public void setRequestPayLoad(RequestPayload requestPayLoad) {
		this.requestPayLoad = requestPayLoad;
	}

}
