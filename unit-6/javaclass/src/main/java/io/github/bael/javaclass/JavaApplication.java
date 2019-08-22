package io.github.bael.javaclass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaApplication {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(
                        TrainingCenterConfiguration.class);

        TrainingCenter center = context.getBean("trainingCenter",
                TrainingCenter.class);

//        System.out.println(center.gloriousWarrior());

        // example 2 - singleton
        TrainingCenterConfiguration cfg =
                context.getBean(TrainingCenterConfiguration.class);

        TrainingCenter center2 = cfg.trainingCenter();
//        /System.out.println(center.equals(center2));

        System.out.println("HI!");
        // @Bean создается только один раз. Почему?
        // класс TrainingCenterConfiguration обертывается прокси, через библиотеку CGLIB
        // внутри вызова метода getBean идет проверка не получался ли уже такой бин, и если да то возвращается он же
        // без инициализации нового

        // Давайте просто посмотрим что в нем
//        System.out.println(cfg);

        for (String s : context.getBeanDefinitionNames()) {

            System.out.println(s + ">>" +context.getBean(s));
        }




        // чтобы показать в каких случаях вызываются хуки
        ((AnnotationConfigApplicationContext) context).close();

    }





}
