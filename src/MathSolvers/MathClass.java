package MathSolvers;

import java.math.BigInteger;

/**
 * Created by Aria Pahlavan on 1/21/17.
 */
public abstract class MathClass {
    BigInteger result;
    final BigInteger n;
    
    public MathClass(BigInteger n) {
        this.n = n;
    }
    
    public abstract void func();
    
    public abstract BigInteger checkTable(BigInteger val);
    
    public BigInteger getResult() {
        return result;
    }
    
    public void setResult(BigInteger result) {
        this.result = result;
    }
}


