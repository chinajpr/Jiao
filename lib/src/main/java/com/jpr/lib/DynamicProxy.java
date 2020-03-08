package com.jpr.lib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-01-06 19:35
 * 邮箱：chinajpr@163.com
 */
public class DynamicProxy {
    public static void main (String [] args){
//        Class man = Person.class;
        Man man = new Man();

        Class aClass = man.getClass();

        //new Class<?>[] { man }
        Person o = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),aClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("代理之前-----");
                Object invoke = method.invoke(new Man(), objects);
                System.out.println(invoke);
                System.out.println("代理之后+++++++");
                return 1;
            }
        });
        int run = o.run();
        System.out.println(run);
    }


    interface Person{
        int run();
    }

    static class  Man implements Person{

        @Override
        public int run() {
            System.out.println("man 跑步");
            return 1;
        }
    }

}
