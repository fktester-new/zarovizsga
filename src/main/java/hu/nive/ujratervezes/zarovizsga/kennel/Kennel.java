package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void feedAll(){
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
