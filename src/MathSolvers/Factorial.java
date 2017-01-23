package MathSolvers;

import java.math.BigInteger;

/**
 * Created by Aria Pahlavan on 1/21/17.
 */
public class Factorial extends MathClass {
    public Factorial(BigInteger n) {
        super(n);
    }
    
    @Override
    public void setResult(BigInteger result) {
        TableMap.facTable.putIfAbsent(n, result);
        super.setResult(result);
    }
    
    public void func() {
        if ( isAvailable() ) return;
        if ( (n.equals(BigInteger.ZERO)) || (n.equals(BigInteger.ONE)) ) setResult(BigInteger.ONE);
        
        else if ( n.signum() == -1 )
            throw new IllegalArgumentException("Illegal value for \'n\': " + n);
        
        else {
            BigInteger res = checkTable(n.subtract(BigInteger.ONE));
            setResult(res.multiply(n));
        }
    }
    
    private boolean isAvailable() {
        if ( TableMap.facTable.containsKey(n) ) {
            result = TableMap.facTable.get(n);
            return true;
        }
        
        return false;
    }
    
    public BigInteger checkTable(BigInteger val) {
        
        if ( TableMap.facTable.containsKey(val) )
            setResult(TableMap.facTable.get(val));
        
        else {
            Factorial newFact = new Factorial(val);
            
            try {
                MathObject.invoke(newFact::func).join();
            } catch (InterruptedException ignored) {
            }
            
            setResult(newFact.getResult());
        }
        
        return getResult();
    }
}


