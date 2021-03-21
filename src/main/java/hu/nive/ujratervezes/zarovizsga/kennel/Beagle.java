package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {


    public Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        increaseHappiness(2);
    }

    @Override
    void play(int hours) {

        increaseHappiness(2 * hours);
    }
}
