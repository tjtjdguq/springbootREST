package com.basic.myspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    @Test
    public void iterable() {
        List<User> users = Arrays.asList(new User("길동", 10), new User("철수", 9), new User("영희", 8));
        for (User user: users) {
            System.out.println("user = " + user);
        }
        //1. Anonymous Inner class
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("익명 내부 클래스 user = " + user);
            }
        });
        //2. Lambda Expression
        users.forEach(user -> System.out.println(user));
        //3. Method Reference
        users.forEach(System.out::println);
    }

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
@ToString
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
