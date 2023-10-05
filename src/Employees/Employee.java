package Employees;

public class Employee {
    private String name;
    private Rank rank;

    public Employee(String initialName, Rank initialrank) {
        this.name = initialName;
        this.rank = initialrank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.rank;
    }
}
