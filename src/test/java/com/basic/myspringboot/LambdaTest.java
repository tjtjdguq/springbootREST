package com.basic.myspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test @Disabled
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

        //3. Lambda Expression
        //Runnble이 가진 run() 메서드를 재정의하는 구문을 람다식으로 표현할 수 있다.
        Thread t3 = new Thread(() -> System.out.println("람다식으로 구현함"));
        t3.start();
    }
}
@Getter
@Setter
@AllArgsConstructor
class User {
    private String name;
    private int age;

//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
}


class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable 구현 클래스 따로 만듬");
    }
}
