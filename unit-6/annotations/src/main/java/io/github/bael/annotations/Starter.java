package io.github.bael.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Starter {

    private GreeterService greeterService;

    public Starter(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

//    @Autowired
//    public void setGreeterService(GreeterService greeterService) {
//        this.greeterService = greeterService;
//    }

    public void greet() {
        System.out.print("Назовите себя:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        String greeting = greeterService.getGreeter().greeting(name);
        System.out.println(greeting);
    }
}
