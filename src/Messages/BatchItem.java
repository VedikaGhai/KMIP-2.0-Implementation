package Messages;

import Objects.XMLTag;

public class BatchItem {
	XMLTag operation;
	XMLTag UniqueBatchItemId;

	public BatchItem(XMLTag operation, XMLTag uniqueBatchItemId) {
		this.operation = operation;
		UniqueBatchItemId = uniqueBatchItemId;
	}

	public XMLTag getOperation() {
		return operation;
	}

	public void setOperation(XMLTag operation) {
		this.operation = operation;
	}

	public XMLTag getUniqueBatchItemId() {
		return UniqueBatchItemId;
	}

	public void setUniqueBatchItemId(XMLTag uniqueBatchItemId) {
		UniqueBatchItemId = uniqueBatchItemId;
	}

	@Override
	public String toString() {
		return "BatchItem [UniqueBatchItemId=" + UniqueBatchItemId + ", operation=" + operation + "]";
	}
	
	
	
	

}
