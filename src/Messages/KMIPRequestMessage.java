package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import KMIPTypes.KMIPType;

import javax.xml.bind.annotation.*;

/**
 * KMIPRequestMessage POJO class.
 * It also describes the order in which the request message should be sent.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see RequestHeader
 * @see RequestBatchItem
 */ 
@XmlRootElement(name = "RequestMessage") 
@XmlType(propOrder = {"requestHeader", "batchItems"}) //for getting the RequestHeader element and BatchItem element in sequence
public class KMIPRequestMessage
{
	RequestHeader requestHeader;
	List<RequestBatchItem> batchItems;
	
	/**
	 * Default constructor.
	 */
	public KMIPRequestMessage()
	{

	}

	/**
	 * Parameterized constructor.
	 * @param requestHeader RequestHeader object
	 * @param batchItems one or more BatchItems, of type RequestBatchItem
	 */
	public KMIPRequestMessage(RequestHeader requestHeader, List<RequestBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<RequestBatchItem>();
		this.requestHeader = requestHeader;
		this.batchItems = batchItems;
	}

	/**
	 * Getter.
	 * @return RequestHeader returns the RequestHeader
	 */
	@XmlElement(name = "RequestHeader") //yes
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	/**
	 * Setter.
	 * @param requestHeader Request Header
	 */
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	/**
	 * Getter.
	 * @return {@code List<RequestBatchItem>} list of batch items in a request message is returned.
	 */
	@XmlElement(name = "BatchItem") //yes
	public List<RequestBatchItem> getBatchItems() {
		return batchItems;
	}

	/**
	 * Setter.
	 * @param batchItems
	 */
	public void setBatchItems(List<RequestBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

	/*@Override
	public String toString() {
		return "KMIPRequestMessage [requestHeader=" + requestHeader + ", batchItem=" + batchItems + "]";
	}*/
}
