package UserInterfacePackage;

import Employees.Rank;

import java.util.List;
import java.util.Scanner;

public class RankRelated {
    public static void addRanks(List<Rank> allRanks, Rank teamLeader, Rank groupLeader, Rank manager, Rank employee) {
        allRanks.add(employee);
        allRanks.add(teamLeader);
        allRanks.add(groupLeader);
        allRanks.add(manager);
    }

    public static void addRankNames(List<String> namesOfRanks, Rank teamLeader, Rank groupLeader, Rank employee, Rank manager) {
        namesOfRanks.add(employee.getNameOfRank());
        namesOfRanks.add(teamLeader.getNameOfRank());
        namesOfRanks.add(groupLeader.getNameOfRank());
        namesOfRanks.add(manager.getNameOfRank());
    }

    public static void modifyingARank(Scanner scanner, List<Rank> allRanks) {
        System.out.println("Which Rank do you wanna modify?");
        for (Rank modifyingRank : allRanks) {
            System.out.println(modifyingRank);
        }
        String rankName = scanner.nextLine();
        for (Rank comparingRank : allRanks) {
            if (comparingRank.getNameOfRank().equals(rankName)) {
                System.out.println("What do you want to modify (Name or Salary)");
                String modify = scanner.nextLine();
                if (modify.equals("Salary")) {
                    System.out.println("To what do you wanna change the Salary?");
                    int change = Integer.parseInt(scanner.nextLine());
                    comparingRank.changeSalary(change);
                    break;
                } else if (modify.equals("Name")) {
                    System.out.println("To what do you wanna change the Name?");
                    String name = scanner.nextLine();
                    comparingRank.changeName(name);
                    break;
                }
            } else {
                System.out.println("Please confirm that you wrote the name correct! (Employee, Team Leader, Group Leader and Manager");
            }
        }
    }
}
