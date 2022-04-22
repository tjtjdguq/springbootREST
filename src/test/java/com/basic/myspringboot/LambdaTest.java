package com.basic.myspringboot;

import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test
    public void runnable() throws Exception {
        //1. MyRunnable 클래스 사용
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        //2. Anonymous Inner 클래스
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable을 익명의 inner 클래스로 만듬");
            }
        });
        t2.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable 구현 클래스 따로 만듬");
    }
}
