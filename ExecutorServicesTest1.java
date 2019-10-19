package org.ie.practice18_10_19;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicesTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /* creates number of threads depending on the argument passed by the programmer.
           Tasks are taken care by these threads there will be no new thread creation takes place,
           only re -use of threads is done.
           There are several methods to control the flow of execution with help of
           Executors framework
         */
        ExecutorService ex= Executors.newFixedThreadPool(3);

        /* submit runs the task and return an  Future object.
        if you use runnable returned object always null cause run method won't return anything.
        But if you use Callable that can return an object with call method.
         */
        Future f=ex.submit(new Thread1("konichiva"));

        /* programmer has to shutdown the service explicitly
        otherwise it will be in running mode only
        */
        ex.shutdown();

        /*prints null to console as run method won't return anything
             */
        System.out.println(f.get());
    }

}
class Thread1 extends Thread{


    public Thread1(String name) {
        super(name);

    }

    @Override
    public void run() {
        System.out.println(super.getName()+" is started by " +currentThread().getName());
        System.out.println(super.getName()+" is completed by " +currentThread().getName());



    }
}
