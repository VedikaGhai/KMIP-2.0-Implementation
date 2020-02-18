package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

@XmlRootElement
public class BatchItem 
{
	
	XMLTag Operation;
	XMLTag UniqueBatchItemId;

	public BatchItem(){
		
	}

	public BatchItem(XMLTag Operation, XMLTag UniqueBatchItemId) {
		this.Operation = Operation;
		this.UniqueBatchItemId = UniqueBatchItemId;
	}

	@XmlElement(name = "Operation")
	public XMLTag getOperation() {
		return Operation;
	}

	public void setOperation(XMLTag Operation) {
		this.Operation = Operation;
	}

	@XmlElement(name = "UniqueBatchItemId")
	public XMLTag getUniqueBatchItemId() {
		return UniqueBatchItemId;
	}

	public void setUniqueBatchItemId(XMLTag uniqueBatchItemId) {
		UniqueBatchItemId = uniqueBatchItemId;
	}

	public String toString() {
		return "BatchItem [UniqueBatchItemId=" + UniqueBatchItemId + ", Operation=" + Operation + "]";
	}
	
}
