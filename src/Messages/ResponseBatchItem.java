package Messages;

import Enum.EnumOperation;
import Enum.EnumResultStatus;
import KMIPTypes.KMIPByteString;

public class ResponseBatchItem extends BatchItem{
	public ResponseBatchItem(EnumOperation operation, KMIPByteString uniqueBatchItemId, RequestPayload requestPayLoad) {
		super(operation, uniqueBatchItemId, requestPayLoad);
		// TODO Auto-generated constructor stub
	}

	EnumResultStatus resultStatus;

}
