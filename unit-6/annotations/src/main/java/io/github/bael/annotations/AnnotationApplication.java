package io.github.bael.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.github.bael.annotations"})
public class AnnotationApplication {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AnnotationApplication.class);

//        GreeterService service = context.getBean(GreeterService.class);
//
//        System.out.print("Назовите себя:");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//
//        String greeting = service.getGreeter().greeting(name);
//        System.out.println(greeting);

        // example 2

        Starter starter = context.getBean(Starter.class);
        starter.greet();


    }
}
