package com.cc.study;

/**
 * Hello world!
 * 什么是快排
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int arr[] = new int[1000];
        for (int i=0; i< 1000;i++){
            int num = (int) (Math.random()*1000+1);
            arr[i] = num;
        }
        for (int i = 0;i<1000 ; i++) {
            System.out.print(i+",");
            if(i%10==0){
                System.out.println();
            }
            if (i==999){
                System.out.println(i);
            }
        }
        sort(arr,0,arr.length-1);

        for (int i = 0;i<1000 ; i++) {
            System.out.print(i+",");
            if(i%10==0){
                System.out.println();
            }
            if (i==999){
                System.out.println(i);
            }
        }
    }

    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void sort1(int[] arr,int lo ,int hi){
        if (lo>=hi)
            return;
        int index =partition(arr,lo,hi);
        sort(arr, lo,index -1);
        sort(arr,index+1,hi);
    }
}
