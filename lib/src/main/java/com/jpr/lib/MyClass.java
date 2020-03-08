package com.jpr.lib;

public class MyClass {
    public void f(int arr[]) {

        int[] temp = new int[21];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        //顺序打印
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String [] args){
        int arr[] = {3,3,1,1,4,5,6,7,8,9};
        MyClass myClass = new MyClass();
        myClass.f(arr);
    }
}
