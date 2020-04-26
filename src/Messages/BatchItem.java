package Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Objects.XMLTag;

/**
 * BatchItem POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */
@XmlRootElement
public class BatchItem 
{
	
	XMLTag Operation;
	XMLTag UniqueBatchItemId;

	/**
	 * Default constructor.
	 */
	public BatchItem(){
		
	}

	/**
	 * Parameterized constructor.
	 * @param Operation the operation for which we are sending the request message. for eg. "Create".
	 * @param UniqueBatchItemId the ID of a particular batch item. 
	 */
	public BatchItem(XMLTag Operation, XMLTag UniqueBatchItemId) {
		this.Operation = Operation;
		this.UniqueBatchItemId = UniqueBatchItemId;
	}

	/**
	 * Getter.
	 * @return XMLTag Operation name
	 */
	@XmlElement(name = "Operation")
	public XMLTag getOperation() {
		return Operation;
	}

	/**
	 * Setter.
	 * @param Operation the operation for which we are sending request message.
	 */
	public void setOperation(XMLTag Operation) {
		this.Operation = Operation;
	}

	/**
	 * Getter.
	 * @return XMLTag UniqueBatchItemID
	 */
	@XmlElement(name = "UniqueBatchItemId")
	public XMLTag getUniqueBatchItemId() {
		return UniqueBatchItemId;
	}

	/**
	 * Setter.
	 * @param uniqueBatchItemId the ID of a particular batch item. 
	 */
	public void setUniqueBatchItemId(XMLTag uniqueBatchItemId) {
		UniqueBatchItemId = uniqueBatchItemId;
	}

	public String toString() {
		return "BatchItem [UniqueBatchItemId=" + UniqueBatchItemId + ", Operation=" + Operation + "]";
	}
	
}
