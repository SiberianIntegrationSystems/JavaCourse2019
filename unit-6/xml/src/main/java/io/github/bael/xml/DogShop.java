package io.github.bael.xml;

import org.springframework.context.annotation.Primary;


public class DogShop implements PetService {
    @Override
    public Pet adorablePet() {
        return new Dog();
    }
}
