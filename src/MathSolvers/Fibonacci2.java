package MathSolvers;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * Created by Aria Pahlavan on 1/21/17.
 */
public class Fibonacci2 implements Callable<BigInteger> {
    public static ExecutorService threadPool = Executors.newCachedThreadPool();
    private BigInteger n;
    
    public Fibonacci2(BigInteger n) {
        this.n = n;
    }
    
    private ResultObject fetchIfExist() {
        ResultObject newResult = new ResultObject().setIsNotAvailable();
        
        if ( TableMap.fibTable.containsKey(n) ) {
            newResult.result = TableMap.fibTable.get(n);
            newResult.setIsAvailable();
        }
        
        return newResult;
    }
    
    private ResultObject fetchIfExist(BigInteger newN) {
        ResultObject newResult = new ResultObject().setIsNotAvailable();
        
        if ( TableMap.fibTable.containsKey(newN) ) {
            newResult.result = TableMap.fibTable.get(newN);
            newResult.setIsAvailable();
        }
        
        return newResult;
    }
    
    public BigInteger call() {
        ResultObject resObj = fetchIfExist();
        if ( resObj.isAvailable() ) return updateTable(resObj.result);
    
        try {
            if ( (n.equals(BigInteger.ZERO)) || (n.equals(BigInteger.ONE)) ) return updateTable(BigInteger.ONE);
            
            else {
                return getSum();
            }
        } catch (Exception e) {
            System.err.println(e);
            return BigInteger.ZERO;
        }
    }
    
    private BigInteger getSum() throws ExecutionException, InterruptedException {
        
        BigInteger f1 = getPrevFib(n.subtract(BigInteger.ONE));
        BigInteger f2 = getPrevFib(n.subtract(BigInteger.valueOf(2)));
    
        return updateTable(f1.add(f2));
    }
    
    private BigInteger getPrevFib(BigInteger prevVal) throws ExecutionException, InterruptedException {
        BigInteger f;
        ResultObject ro = fetchIfExist(prevVal);
        
        if ( ro.isAvailable() ) f = ro.result;
        else f = getSubmit(prevVal);
        
        return updateTable(f, prevVal);
    }
    
    private BigInteger getSubmit(BigInteger val) throws ExecutionException, InterruptedException {
        return threadPool.submit(new Fibonacci2(n.subtract(BigInteger.ONE))).get();
    }
    
    private BigInteger updateTable(BigInteger result) {
        TableMap.fibTable.putIfAbsent(n, result);
        return result;
    }
    
    private BigInteger updateTable(BigInteger result, BigInteger val) {
        TableMap.fibTable.putIfAbsent(val, result);
        return result;
    }
    
    class ResultObject {
        BigInteger result;
        private boolean bool;
        
        boolean isAvailable() {
            return bool;
        }
    
        void setIsAvailable(){
            bool = true;
        }
    
        ResultObject setIsNotAvailable(){
            bool = false;
            return this;
        }
    }
}

