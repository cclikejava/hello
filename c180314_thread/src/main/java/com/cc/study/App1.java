package com.cc.study;

/**
 * 通过来继承Thread类开启多线程
 */
public class App1 extends Thread {
    public void run(){
        int i =3;
        for (int k=10;k>0;k--)
        System.out.println(k+Thread.currentThread().getName());
    }
}
