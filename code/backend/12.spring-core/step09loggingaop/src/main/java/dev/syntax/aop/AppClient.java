package dev.syntax.aop;

import dev.syntax.aop.config.BeanConfiguration;
import dev.syntax.aop.controller.CoffeeController;
import dev.syntax.aop.model.Coffee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppClient {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        CoffeeController coffeeController = ctx.getBean(CoffeeController.class);
        System.out.println(coffeeController);

        coffeeController.getCoffees();

        Coffee coffee = new Coffee(1, "페퍼민트");
        coffeeController.saveCoffee(coffee);
    }
}
