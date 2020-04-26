package Objects;

import javax.xml.crypto.dsig.keyinfo.*;

/**
 * KeyValue POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see XMLTag
 */ 
public class KeyValue
{
    XMLTag KeyMaterial;

    /**
     * Parameterized constructor.
     * @param keyMaterial actual content of the key
     */
    public KeyValue(XMLTag keyMaterial) {
        KeyMaterial = keyMaterial;
    }

    /**
     * Getter.
     * @return XMLTag key material
     */
    public XMLTag getKeyMaterial() {
        return KeyMaterial;
    }

    /**
     * Setter.
     * @param keyMaterial
     */
    public void setKeyMaterial(XMLTag keyMaterial) {
        KeyMaterial = keyMaterial;

    }

}