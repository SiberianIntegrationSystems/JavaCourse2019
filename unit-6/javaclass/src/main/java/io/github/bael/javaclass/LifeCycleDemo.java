package io.github.bael.javaclass;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleDemo {

    public void onInited() {
        System.out.println("Life Cycle: onInited");
    }

    public void onDestroy() {
        System.out.println("Life Cycle: onDestroy");
    }

    /**
     * The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done
     * to perform any initialization.
     * This method MUST be invoked before the class is put into service.
     * This annotation MUST be supported on all classes that support dependency injection.
     * The method annotated with PostConstruct MUST be invoked even if the class does not request any resources to be injected.
     * Only one method in a given class can be annotated with this annotation.
     */
    @PostConstruct
    public void postConstruct() {

        System.out.println("Life Cycle: @onPostConstruct");
    }

    /**
     * javax.annotation.PreDestroy The PreDestroy annotation is used on a method as a callback notification to signal that
     * the instance is in the process of being removed by the container.
     * The method annotated with PreDestroy is typically used to release resources that the instance has been holding.
     * This annotation MUST be supported by all container managed objects that support PostConstruct except the application client.
     *
     *
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("Life Cycle: @onPreDestroy");

    }
}
