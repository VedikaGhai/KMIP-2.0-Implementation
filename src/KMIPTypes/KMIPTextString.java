package KMIPTypes;

public class KMIPTextString extends KMIPType{

    String value;

    public KMIPTextString(String value){
        super(0);
        this.value = value;
    }

    @Override
    public String toString() {
        return "KMIPTextString [value=" + value + "]";
    }
    
}