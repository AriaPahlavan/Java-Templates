import MathSolvers.Fibonacci2;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Fibonacci2 f = new Fibonacci2(BigInteger.valueOf(12345678));
        Future<BigInteger> f1 = es.submit(f);
        System.out.println("Answer is " + f1.get());
        es.shutdown();
        Fibonacci2.threadPool.shutdown();
    }
    
    
}

