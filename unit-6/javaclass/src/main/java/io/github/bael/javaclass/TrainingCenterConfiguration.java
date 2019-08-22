package io.github.bael.javaclass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingCenterConfiguration {

    @Bean
    public TrainingCenter trainingCenter() {
        return new BarbarianTrainingCenter();
    }


    @Bean
    public TrainingCenter trainingCenterKnight() {
        return new KnightTrainingCenter();
    }


    @Bean(initMethod = "onInited", destroyMethod = "onDestroy")
    public LifeCycleDemo lifeCycle() {
        return new LifeCycleDemo();
    }

}
