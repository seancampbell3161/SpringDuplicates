package com.example.sfdiduplicate;

import com.example.sfdiduplicate.controllers.ConstructorInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfDiDuplicateApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfDiDuplicateApplication.class, args);

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
                ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());
    }

}
