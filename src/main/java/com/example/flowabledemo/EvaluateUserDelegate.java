package com.example.flowabledemo;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EvaluateUserDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        var min = 1;
        var max = 10;
        var score = new Random().nextInt(max - min + 1) + min;
        execution.setVariable("score", score);

        System.out.println("setting score: " + score);
    }
}
