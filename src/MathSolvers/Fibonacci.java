package MathSolvers;

import java.math.BigInteger;

/**
 * Created by Aria Pahlavan on 1/21/17.
 */
public class Fibonacci extends MathClass {
    public Fibonacci(BigInteger n) {
        super(n);
    }
    
    @Override
    public void setResult(BigInteger result) {
        TableMap.fibTable.putIfAbsent(n, result);
        super.setResult(result);
    }
    
    private BigInteger setTable(BigInteger result, BigInteger val) {
        TableMap.fibTable.putIfAbsent(val, result);
        return result;
    }
    
    public void func() {
        if ( isAvailable() ) return;
        if ( (n.equals(BigInteger.ZERO)) || (n.equals(BigInteger.ONE)) ) setResult(BigInteger.ONE);
        
        else if ( n.signum() == -1 )
            throw new IllegalArgumentException("Illegal value for \'n\': " + n);
        
        else {
            BigInteger res1 = checkTable(n.subtract(BigInteger.ONE));
            BigInteger res2 = checkTable(n.subtract(BigInteger.valueOf(2)));
            setResult(res1.add(res2));
        }
    }//1, 1, 2, 3, 5, 8
     //0, 1, 2, 3, 4, 5
    private boolean isAvailable() {
        if ( TableMap.fibTable.containsKey(n) ) {
            result = TableMap.fibTable.get(n);
            return true;
        }
        
        return false;
    }
    
    public BigInteger checkTable(BigInteger val) {
        BigInteger res;
        
        if ( TableMap.fibTable.containsKey(val) )
            res = TableMap.fibTable.get(val);
        
        else {
            Fibonacci newFib = new Fibonacci(val);
            
            try {
                MathObject.invoke(newFib::func).join();
            } catch (InterruptedException ignored) {
            }
            
            res = setTable(newFib.getResult(), val);
        }
        
        return res;
    }
}

