package com.codepowered.tryout.play_sird_in_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("application.xml").start();
    }
}
