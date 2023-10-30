package Employees;

import java.util.ArrayList;

public class Rank {
    private String nameOfRank;
    private double salary;
    private int power;

    public Rank(String nameOfRank, double salary, int power) {
        this.nameOfRank = nameOfRank;
        this.salary = salary;
        this.power = power;
    }
    public int getPower() {
        return power;
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
        return "Rank Name: " + this.nameOfRank + ", " + "Salary: " + this.salary + ", " + "Power: " + this.power;
    }
}
