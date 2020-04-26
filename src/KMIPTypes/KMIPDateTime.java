package KMIPTypes;

import java.text.*;
import java.util.*;

/**
 * KMIPDateTime POJO class.
 * It describes the DateTime data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */ 
public class KMIPDateTime extends KMIPType{

    String pattern = "YYYY-MM-dd'T'HH:mm:ssZ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    String date;

    /**
     * Parameterized constructor.
     * @param value DateTime value in the form of a String.
     * @throws ParseException
     * @see ParseException
     */
    public KMIPDateTime(String value) throws ParseException {
        super(value); 
        date = simpleDateFormat.format(new Date());
        date = String.valueOf(simpleDateFormat.parse(date));
    }

    /**
     * Getter.
     * @return String date
     */
    public String getValue() {
        return date;
    }

    @Override
    public String toString() {
        return "KMIPDateTime [date=" + date + ", pattern=" + pattern + ", simpleDateFormat=" + simpleDateFormat + "]";
    }

    
    
    

    


}