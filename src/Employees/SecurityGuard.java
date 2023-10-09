package Employees;

public class SecurityGuard {

    private String name;
    private double salary;
    private ID id;

    public SecurityGuard(String name, double salary, ID id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }
    public ID getId() {
        return this.id;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + ", Salary: " + this.salary + ", " + getId();
    }
}
