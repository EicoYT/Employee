package Employees;

import java.util.ArrayList;

public class Rank {
    private String nameOfRank;
    private double salary;

    public Rank(String initialNameOfRank, double initialSalary) {
        this.nameOfRank = initialNameOfRank;
        this.salary = initialSalary;
    }

    public String getNameOfRank() {
        return nameOfRank;
    }

    public double getSalary() {
        return salary;
    }

    public void changeSalary(int change) {
        this.salary = change;
    }

    public void changeName(String name) {
        this.nameOfRank = name;
    }

    @Override
    public String toString() {
        return "Rank name: " + this.nameOfRank + ", " + "salary: " + this.salary;
    }
}
