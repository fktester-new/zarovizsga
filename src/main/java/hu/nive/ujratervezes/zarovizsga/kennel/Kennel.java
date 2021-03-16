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

    public Dog findByName(String name){
        Dog result = null;
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)){
                result = dog;
            }
        }
        if (result == null){
            throw new IllegalArgumentException("There is no dog with this name!");
        }
        return result;
    }

    public void playWith(String name, int hours){
        Dog lucky = findByName(name);
        lucky.play(hours);
    }
}
