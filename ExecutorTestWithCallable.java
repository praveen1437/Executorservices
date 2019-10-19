package org.ie.practice18_10_19;

import java.util.concurrent.*;

public class ExecutorTestWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex= Executors.newFixedThreadPool(3);
       Future f = ex.submit(new Thread2());

        System.out.println(ex.isShutdown());

        System.out.println(ex.isTerminated());
        ex.shutdown();
        System.out.println(ex.isShutdown());
        System.out.println(ex.isTerminated());
        System.out.println(f.get());
        System.out.println(ex.isTerminated());

    }
}
class Thread2 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("started and ended");
        return "omedetho";
    }
}