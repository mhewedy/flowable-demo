package com.example.camundademo;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaDemoApplication implements CommandLineRunner {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(CamundaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ProcessInstance userEvaluation = runtimeService.startProcessInstanceByKey("userEvaluation");
        System.out.println(userEvaluation.getProcessInstanceId());

        taskService.createTaskQuery().active().list().forEach(task -> {
            System.out.println("completing task: " + task.getId());
            taskService.complete(task.getId());
        });
    }
}
