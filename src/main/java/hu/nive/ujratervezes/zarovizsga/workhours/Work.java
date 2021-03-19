package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Work {

    private String name;
    private int workHours;
    private LocalDate workDate;

    public Work(String name, int workHours, LocalDate workDate) {
        this.name = name;
        this.workHours = workHours;
        this.workDate = workDate;
    }

    public String getName() {
        return name;
    }

    public int getWorkHours() {
        return workHours;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }


    @Override
    public String toString() {
        return name + ": " + workDate;
    }
}
