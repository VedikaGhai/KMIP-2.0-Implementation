package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * KMIPResponseMessage POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see ResponseHeader
 * @see ResponseBatchItem
 */
@XmlRootElement(name = "ResponseMessage") 
//@XmlType(propOrder = {"responseHeader", "batchItems"}) //for getting the ResponseHeader element and BatchItem element in sequence
public class KMIPResponseMessage
{
	ResponseHeader responseHeader;
	List<ResponseBatchItem> batchItems;
	
	/**
	 * Default constructor.
	 */
	public KMIPResponseMessage()
	{

	}

	/**
	 * Parameterized constructor.
	 * @param responseHeader 
	 * @param batchItems
	 */
	public KMIPResponseMessage(ResponseHeader responseHeader, List<ResponseBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<ResponseBatchItem>();
		this.responseHeader = responseHeader;
		this.batchItems = batchItems;
	}

	/**
	 * Getter. 
	 * @return ResponseHeader
	 */
	@XmlElement(name = "ResponseHeader") //yes
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	/**
	 * Setter.
	 * @param responseHeader
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	/**
	 * Getter.
	 * @return {@code List<ResponseBatchItem>} returns one and more (if applicable) batch items from the response message.
	 */
	@XmlElement(name = "BatchItem") //yes
	public List<ResponseBatchItem> getBatchItems() {
		return batchItems;
	}

	/**
	 * Setter.
	 * @param batchItems
	 */
	public void setBatchItems(List<ResponseBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

}
