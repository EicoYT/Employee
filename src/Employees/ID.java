package Employees;

public class ID {
    private String iDNumber;
    private int iDRank;

    public ID(int iDRank, String iDNumber) {
        this.iDNumber = iDNumber;
        this.iDRank = iDRank;
    }

    public String getNumberOfID() {
        return this.iDNumber;
    }

    public int getRankOfID() {
        return this.iDRank;
    }

    @Override
    public String toString() {
        return "IDNumber: " + this.iDNumber + ", Rank: " + this.iDRank;
    }
}
