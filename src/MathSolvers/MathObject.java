package MathSolvers;

/**
 * Created by Aria Pahlavan on 1/21/17.
 */
class MathObject {
    static Thread invoke(Runnable func) {
        Thread thread = new Thread(func);
        thread.start();
        return thread;
    }
}
