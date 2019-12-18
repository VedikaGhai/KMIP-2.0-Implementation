package KMIPTypes;

public class KMIPType {
	int defaultLength;
	KMIPType(int defaultLength)
	{
		this.defaultLength=defaultLength;
	}
	KMIPType(String value)
	{
		
	}
	public int getDefaultLength()
	{
		return this.defaultLength;
	}

	@Override
	public String toString() {
		return "KMIPType [defaultLength=" + defaultLength + "]";
	}

	
}
