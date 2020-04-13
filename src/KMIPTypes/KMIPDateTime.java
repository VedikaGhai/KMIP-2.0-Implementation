package KMIPTypes;

import java.time.format.DateTimeFormatter;
import java.text.*;
import java.util.*;

public class KMIPDateTime extends KMIPType{

    String pattern = "YYYY-MM-dd'T'HH:mm:ssZ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    String date;


    public KMIPDateTime(String value) throws ParseException {
        super(value); 
        date = simpleDateFormat.format(new Date());
        date = String.valueOf(simpleDateFormat.parse(date));
    }

    public String getValue() {
        return date;
    }

    @Override
    public String toString() {
        return "KMIPDateTime [date=" + date + ", pattern=" + pattern + ", simpleDateFormat=" + simpleDateFormat + "]";
    }

    
    
    

    


}