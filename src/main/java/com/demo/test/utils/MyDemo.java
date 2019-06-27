package com.demo.test.utils;

public class MyDemo {
    int i = 0;
    public void increase() {
        i++;
    }

    public static void main(String[] args) throws Exception {
        MyDemo demo = new MyDemo();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread());
                for (int j = 0; j < 10000; j++) {
                    demo.increase();
                }
            }
            ).start();
        }
        Thread.sleep(1000L);
        System.out.println(demo.i);
    }
}
