package com.jpr.lib;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-01-31 15:13
 * 邮箱：chinajpr@163.com
 */
public class DiGui {
    private static int print(int n){//2.参数n的值每次递归的时候要改变
        if (n == 0){
            return 0;//3.最后一次返回的值
        } else {
            System.out.println(n);//4.每次递归执行的函数
            return print(n-1);//5.改变参数，并调用自身 / 6.返回值
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }else {
            return factorial(n-1);
        }
    }

    public static void main(String [] args){
//        int print = print(8);
        int factorial = factorial(3);
        System.out.println(factorial + "------");
    }
}
