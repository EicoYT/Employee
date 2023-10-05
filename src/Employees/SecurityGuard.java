package Employees;

public class SecurityGuard {

    private String name;
    private int salary;
    private int securityNumber;
    private int securityRank;

    public SecurityGuard(String name, int salary, int securityNumber, int securityRank) {
        this.name = name;
        this.salary = salary;
        this.securityNumber = securityNumber;
        this.securityRank = securityRank;
    }

    public int getSecurityRank() {
        return this.securityRank;
    }

    public int getSecurityNumber() {
        return this.securityNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }
}
