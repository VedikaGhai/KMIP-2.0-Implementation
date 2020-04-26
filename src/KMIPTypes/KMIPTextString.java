package KMIPTypes;

/**
 * KMIPTextString POJO class.
 * It describes the String data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */
public class KMIPTextString extends KMIPType{

    String value;
    
    /**
     * Parameterized constructor.
     * @param value String value
     */
    public KMIPTextString(String value){
        super(0);
        this.value = value;
    }

    @Override
    public String toString() {
        return "KMIPTextString [value=" + value + "]";
    }

    /**
     * Getter.
     * @return String value.
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * Setter.
     * @param value String value.
     */
    public void setValue(String value)
    {
        this.value=value;
    }
    
}