package org.ie.practice18_10_19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAnyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex= Executors.newFixedThreadPool(3);
        List<Callable<ThreadInvokeAny>> tk= new ArrayList<>();
        tk.add(new ThreadInvokeAny("hello"));
        tk.add(new ThreadInvokeAny("jhfcdhfjdjf"));
        tk.add(new ThreadInvokeAny("jhfcjsdjdjf"));
        tk.add(new ThreadInvokeAny("jcjsdhfjdjf"));
        tk.add(new ThreadInvokeAny("jhfcjsdhfjf"));
        tk.add(new ThreadInvokeAny("jjsdhfjdjf"));


ThreadInvokeAny t= ex.invokeAny(tk);
      System.out.println(t);

     ex.shutdown();
    }
}
class ThreadInvokeAny implements Callable{
    String name;

    public ThreadInvokeAny(String name) {
        this.name = name;
    }

    @Override
    public ThreadInvokeAny call() throws Exception {
        return this;
    }
}