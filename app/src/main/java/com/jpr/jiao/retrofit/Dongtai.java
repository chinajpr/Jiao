package com.jpr.jiao.retrofit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.Call;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-01-06 19:19
 * 邮箱：chinajpr@163.com
 */
public class Dongtai {
    T t = new T();

    PostRequest_Interface proxyHello = (PostRequest_Interface) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.invoke(t , args);
            return null;
        }
    });

    private void show(){
        proxyHello.getCall("");
    }

        class T implements PostRequest_Interface{

            @Override
            public Call<Translation> getCall(String targetSentence) {
                return null;
            }

            public void show(){

            }
        }
}
