package com.cc.study;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

       // System.out.println("当前线程是"+Thread.currentThread().getName());

        App1 app1 = new App1();

        Thread thread1 = new Thread(app1);
        Thread thread2 = new Thread(app1);
        thread1.start();
        thread2.start();
    }
}
