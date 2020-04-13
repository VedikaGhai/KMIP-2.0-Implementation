package Messages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseMessage") 
//@XmlType(propOrder = {"responseHeader", "batchItems"}) //for getting the ResponseHeader element and BatchItem element in sequence
public class KMIPResponseMessage
{
	ResponseHeader responseHeader;
	List<ResponseBatchItem> batchItems;
	
	//@XmlAttribute(name="Name") - Working!
	//String hi = "Soha";

	public KMIPResponseMessage()
	{

	}

	//Response Message setter
	public KMIPResponseMessage(ResponseHeader responseHeader, List<ResponseBatchItem> batchItems) {
		super();
		this.batchItems = new ArrayList<ResponseBatchItem>();
		this.responseHeader = responseHeader;
		this.batchItems = batchItems;
	}

	/* Working!
	public String getString()
	{
		return hi;
	}*/

	@XmlElement(name = "ResponseHeader") //yes
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	@XmlElement(name = "BatchItem") //yes
	public List<ResponseBatchItem> getBatchItems() {
		return batchItems;
	}

	public void setBatchItems(List<ResponseBatchItem> batchItems) {
		this.batchItems = batchItems;
	}

}
