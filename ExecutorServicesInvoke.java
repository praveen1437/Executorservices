package org.ie.practice18_10_19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicesInvoke {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Threadinvoke th= new Threadinvoke("hello");
        /* creates a List object which holds multiple tasks of Callable type*/
        List<Callable<Threadinvoke>> th2;
        th2= new ArrayList<>();


           th2.add(th);
           th2.add(new Threadinvoke("konchiva"));
           th2.add(new Threadinvoke("omedeto"));
           th2.add(new Threadinvoke("dameda"));
           th2.add(new Threadinvoke("kawai"));

       //create executor service of size 2
        ExecutorService ex= Executors.newFixedThreadPool(1);

       // hold the list of returned future object from invokeAll method
       List<Future<Threadinvoke>> f;
        f=  ex.invokeAll(th2);


        //process the future objects
        for (Future f1: f
             ) {
            System.out.println(f1.get()+"  "+f1);
        }
        ex.shutdown();
    }

}


//class implements callable interface
class Threadinvoke implements Callable {
      String name;
    public Threadinvoke(String name) {
        this.name=name;
    }

    @Override
    public Object call() {
        System.out.println(name+" started by "+ Thread.currentThread().getName());
        System.out.println(name+" completed by "+ Thread.currentThread().getName());
        return name;
    }
}
