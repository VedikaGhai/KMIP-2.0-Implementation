package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement
public class BatchItem {
	XMLTag operation;
	XMLTag UniqueBatchItemId;

	public BatchItem(){
		
	}

	public BatchItem(XMLTag operation, XMLTag uniqueBatchItemId) {
		this.operation = operation;
		UniqueBatchItemId = uniqueBatchItemId;
	}

	@XmlElement
	public XMLTag getOperation() {
		return operation;
	}

	public void setOperation(XMLTag operation) {
		this.operation = operation;
	}

	@XmlElement
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
