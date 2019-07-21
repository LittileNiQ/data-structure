package com.data.structure.practice.leecode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Naqi on 2019/7/8.
 */
//
//public class Singleton {
//
//    private static class Inner {
//        private static Singleton singleton = new Singleton();
//
//        static {
//            System.out.println("内部类被解析了");
//        }
//    }
//
//
//    private Singleton() {
//    }
//
//
//    public static Singleton getInstance() {
//        return Inner.singleton;
//    }
//
//    public static void main(String[] args) {
////        Class<Singleton> clazz = null;
////        try {
////            clazz = (Class<Singleton>) Class.forName("com.data.structure.practice.leecode.Singleton");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        System.out.println("外部类被解析\n" + clazz);
//        System.out.println(Singleton.getInstance());
//    }
//}
public class Singleton {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    private Singleton() {}

    public static Singleton getInstance() {
        for (;;) {
            Singleton singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new Singleton();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}