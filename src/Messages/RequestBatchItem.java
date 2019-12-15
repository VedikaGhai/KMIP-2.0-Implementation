package Messages;

import Enum.EnumOperation;
import KMIPTypes.KMIPByteString;

public class RequestBatchItem extends BatchItem {

	public RequestBatchItem(EnumOperation operation, KMIPByteString uniqueBatchItemId, RequestPayload requestPayLoad) {
		super(operation, uniqueBatchItemId, requestPayLoad);
		// TODO Auto-generated constructor stub
	}

}
