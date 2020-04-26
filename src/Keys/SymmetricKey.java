package Keys;

import Enum.KMIPEnum;
import Objects.KeyBlock;

/**
 * SymmetricKey POJO class.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KeyBlock
 */ 
public class SymmetricKey
{
    KeyBlock keyBlock;

    /**
     * Parameterized constructor.
     * @param keyBlock object of type KeyBlock which has KeyFormatType, CryptographicAlgorithm, CryptographicLength and KeyValue wrapped in it.
     */
    public SymmetricKey(KeyBlock keyBlock) {
        this.keyBlock = keyBlock;
    }

    /**
     * Getter.
     * @return KeyBlock key block object
     */
    public KeyBlock getKeyBlock() {
        return keyBlock;
    }

    /**
     * Setter.
     * @param keyBlock Key Block object
     */
    public void setKeyBlock(KeyBlock keyBlock) {
        this.keyBlock = keyBlock;
    }

 
}