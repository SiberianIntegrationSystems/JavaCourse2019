package io.github.bael.xml;

public class CatShop implements PetService {

    private Toy toy;

    public CatShop(Toy toy) {
        this.toy = toy;
    }

    @Override
    public Pet adorablePet() {
        Cat cat = new Cat(toy);

        return cat;
    }
}
