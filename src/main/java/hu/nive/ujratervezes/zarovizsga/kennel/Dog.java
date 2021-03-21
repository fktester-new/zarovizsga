package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    String name;
    int happiness;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    abstract void feed();

    abstract void play(int hours);

    protected void increaseHappiness(int diff){
        happiness += diff;
    }
}
