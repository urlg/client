package com.demo.untils.Exception;

/**
 * 饿汉式单例模式
 */
public class Singleton {
    private  Singleton(){}
    private static  final  Singleton  singleton = new Singleton();

    //静态工厂方法
    public  static  Singleton getInstance(){
        return singleton;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
