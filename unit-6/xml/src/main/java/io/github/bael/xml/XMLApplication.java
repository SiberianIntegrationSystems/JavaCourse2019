package io.github.bael.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XMLApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationXMLConfig.xml");

        // bean petService по умолчанию
        PetService service = applicationContext.getBean(PetService.class);
        // bean petService - явно задаем кошачий
        PetService serviceCat = (PetService) applicationContext.getBean("PetServiceCat");
        // bean petService - явно задаем собачий
        PetService serviceDog = (PetService) applicationContext.getBean("PetServiceDog");


        System.out.println(serviceDog.adorablePet().speak());
        System.out.println(serviceCat.adorablePet().speak());

        System.out.println("cat's toy is: " + serviceCat.adorablePet().toy());

        System.out.println("default: " + service.adorablePet().speak());
    }
}
