package com.example.sfdiduplicate;

import com.example.sfdiduplicate.controllers.ConstructorInjectedController;
import com.example.sfdiduplicate.controllers.I18nController;
import com.example.sfdiduplicate.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfDiDuplicateApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfDiDuplicateApplication.class, args);

        MyController primaryController = (MyController) ctx.getBean("myController");

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");

        System.out.println(i18nController.sayHello());

        System.out.println(primaryController.sayHello());

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
                ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());
    }

}
