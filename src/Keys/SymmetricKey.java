package Keys;
import Objects.KeyBlock;

public class SymmetricKey
{
    KeyBlock keyBlock;

    public SymmetricKey(KeyBlock keyBlock) {
        this.keyBlock = keyBlock;
    }

    
    public KeyBlock getKeyBlock() {
        return keyBlock;
    }

    public void setKeyBlock(KeyBlock keyBlock) {
        this.keyBlock = keyBlock;
    }

 
}