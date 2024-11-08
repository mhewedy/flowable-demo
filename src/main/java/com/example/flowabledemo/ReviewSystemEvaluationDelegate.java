package com.example.flowabledemo;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ReviewSystemEvaluationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        int score = (int) execution.getVariable("score");

        if (score < 5) {
            execution.setVariable("accept", false);
            System.out.println("not accepting!");
        } else {
            execution.setVariable("accept", true);
            System.out.println("accepting!");
        }
    }
}
